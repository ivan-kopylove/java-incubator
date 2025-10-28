package heap.c114;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.amqp.autoconfigure.RabbitConnectionDetails;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.testcontainers.containers.RabbitMQContainer;
import org.testcontainers.utility.DockerImageName;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyString;

@SpringJUnitConfig // what if I replace it with the members of this composite?
class ServiceConnectionExample
{
    /// what if there is no @ServiceConnection?
    /// how this connected to DynamicPropertyRegistry?
    /// What are the ways to access properties registerd by @ServiceConnection?
    /// Is @ServiceConnection works only with @TestConfiguration?
    @ServiceConnection
    private static RabbitMQContainer rabbit = new RabbitMQContainer(DockerImageName.parse("rabbitmq:3.7.25-management-alpine"));

    @Autowired
    private RabbitConnectionDetails connectionDetails;

    @Test
    void exercise_design_reverse_engineering() throws SQLException
    {
        assertThat(connectionDetails, notNullValue());
        assertThat(connectionDetails.getPassword(), is(not(emptyString())));
        assertThat(connectionDetails.getUsername(), is(not(emptyString())));
        rabbit.stop();
    }
}


