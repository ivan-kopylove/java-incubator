package com.github.ivan.kopylove.commons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ShellExecutor
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ShellExecutor.class);

    private final ShellExecutorParameters shellExecutorParameters;

    public ShellExecutor(ShellExecutorParameters shellExecutorParameters)
    {
        this.shellExecutorParameters = shellExecutorParameters;
    }

    public void exec(String command) {
        try {
            LOGGER.trace("Executing {}", command);
            List<String> bash = new ArrayList<>();
            bash.add("/bin/bash");
            bash.add("-c");
            bash.add(command);

            ProcessBuilder builder = new ProcessBuilder(bash);

            builder.directory(shellExecutorParameters.getWorkingDir().toFile().getAbsoluteFile());
            Process process = builder.start();

            StreamGobbler regular = new StreamGobbler(process.getInputStream(), "regular");
            StreamGobbler err = new StreamGobbler(process.getErrorStream(), "errors");

            Future<?> errFuture = shellExecutorParameters.getStreamGobblerPool().submit(err);
            Future<?> future = shellExecutorParameters.getStreamGobblerPool().submit(regular);

            int exitCode = process.waitFor();
            LOGGER.trace("exitcode: {}", exitCode);

            future.get(10, SECONDS);
            errFuture.get(10, SECONDS);
        } catch (IOException | InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}