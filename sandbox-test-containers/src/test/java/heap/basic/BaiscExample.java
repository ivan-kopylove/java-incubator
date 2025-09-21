package heap.basic;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;

public class BaiscExample
{
    @Test
    void what_will_be_printed()
    {
        // given
        GenericContainer simpleWebServer = new GenericContainer("alpine:3.2")
                .withExposedPorts(80)
                                                                             .withCommand("/bin/sh",
                                                                                          "-c",
                                                                                          "while true; do echo " + "\"HTTP/1.1 200 OK\n\nHello World!\" | nc -l -p 80; done");

        simpleWebServer.start();

        System.out.println(simpleWebServer.getHost() + ":" + simpleWebServer.getFirstMappedPort());

    }
}
