package heap.c113;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.RabbitMQContainer;
import org.testcontainers.utility.DockerImageName;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

class RabbitMQContainerExample
{
    private RabbitMQContainer rabbit = new RabbitMQContainer(DockerImageName.parse("rabbitmq:4.1.4-management-alpine"));

    @Test
    void exercise_design_reverse_engineering() throws SQLException
    {
        rabbit.start();
        assertThat(rabbit.isRunning(), Matchers.is(true));
        rabbit.stop();
        assertThat(rabbit.isRunning(), Matchers.is(false));
    }
}


