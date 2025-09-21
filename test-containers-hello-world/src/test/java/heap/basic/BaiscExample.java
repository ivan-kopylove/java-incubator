package heap.basic;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class BaiscExample
{
    @Test
    void what_will_be_printed()
    {
        GenericContainer container = new GenericContainer("alpine:3.2").withExposedPorts(80);

        // when
        container.start();

        // then
        String address = container.getHost() + ":" + container.getExposedPorts().getFirst();
        System.out.println(address);
        assertThat(address, equalTo("localhost:80"));

        container.stop();
    }
}
