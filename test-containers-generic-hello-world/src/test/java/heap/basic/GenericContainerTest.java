package heap.basic;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GenericContainerTest
{
    @Test
    void reverse_engineer_hypothetical_design()
    {
        GenericContainer container = new GenericContainer("alpine:3.2") //
                .withExposedPorts(80)//
                // what is the purpose of this command?
                .withCommand("/bin/sh", "-c", "while true; do echo \"HTTP/1.1 200 OK\n\nHello World!\" | nc -l -p 80; done");

        // when
        container.start();

        // then
        String address = container.getHost() + ":" + container.getExposedPorts().getFirst();
        System.out.println(address);
        assertThat(address, equalTo("localhost:80"));

        container.stop();
    }
}
