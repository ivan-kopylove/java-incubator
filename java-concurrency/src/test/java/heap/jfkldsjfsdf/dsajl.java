package heap.jfkldsjfsdf;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.logging.Logger;

 class dsajl
{

    @Test
    void exercise_design_reverse_engineering1()
    {
        // given
        ForkJoinPool commonPool = ForkJoinPool.commonPool();

        // when
        commonPool.invoke(new CustomRecursiveAction("Lorem Ipsum is simply dummy text of the printing and typesetting industry"));

        // then
//        System.out.println(result);
    }

}

class CustomRecursiveAction extends RecursiveAction
{
    private String workload = "";
    private static final int THRESHOLD = 4;

    private static Logger logger = Logger.getAnonymousLogger();

     CustomRecursiveAction(String workload) {
        this.workload = workload;
    }

    @Override
    protected void compute() {
        if (workload.length() > THRESHOLD) {
            ForkJoinTask.invokeAll(createSubtasks());
        } else {
            process(workload);
        }
    }

    private List<CustomRecursiveAction> createSubtasks() {
        List<CustomRecursiveAction> subtasks = new ArrayList<>();

        String partOne = workload.substring(0, workload.length() / 2);
        String partTwo = workload.substring(workload.length() / 2, workload.length());

        subtasks.add(new CustomRecursiveAction(partOne));
        subtasks.add(new CustomRecursiveAction(partTwo));

        return subtasks;
    }

    private void process(String work) {
        String result = work.toUpperCase();
        logger.info("This result - (" + result + ") - was processed by " + Thread.currentThread().getName());
    }
}

