package heap.jfkasd;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.testcontainers.containers.RabbitMQContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringJUnitConfig
@Testcontainers(disabledWithoutDocker = true)
@DirtiesContext
class ConsumerConnectionRecoveryTests
{
    @Container
    private static final RabbitMQContainer RABBIT_MQ_CONTAINER = new RabbitMQContainer(DockerImageName.parse("rabbitmq"));

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    @Qualifier("connectionFactory")
    private CachingConnectionFactory cachingConnectionFactory;

    @Autowired
    @Qualifier("publisherConnectionFactory")
    private CachingConnectionFactory publisherConnectionFactory;

    @Test
    void verifyThatChannelPermitsAreReleaseOnReconnect(@Autowired TestConfiguration config) throws InterruptedException
    {
        rabbitTemplate.convertAndSend("testQueue", "test data #1");

        assertThat(config.received.poll(20, TimeUnit.SECONDS), equalTo("test data #1"));

        RABBIT_MQ_CONTAINER.stop();
        RABBIT_MQ_CONTAINER.start();

        cachingConnectionFactory.setPort(RABBIT_MQ_CONTAINER.getAmqpPort());
        publisherConnectionFactory.setPort(RABBIT_MQ_CONTAINER.getAmqpPort());

        rabbitTemplate.convertAndSend("testQueue", "test data #2");

        assertThat(config.received.poll(30, TimeUnit.SECONDS), equalTo("test data #2"));
    }

    @Configuration
    @EnableRabbit
    static class TestConfiguration
    {
        private BlockingQueue<String> received = new LinkedBlockingQueue<>();

        @Bean
        CachingConnectionFactory connectionFactory()
        {
            CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost",
                                                                                      RABBIT_MQ_CONTAINER.getAmqpPort());
            connectionFactory.setChannelCacheSize(1);
            connectionFactory.setChannelCheckoutTimeout(2000);
            return connectionFactory;
        }

        @Bean
        CachingConnectionFactory publisherConnectionFactory()
        {
            CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost",
                                                                                      RABBIT_MQ_CONTAINER.getAmqpPort());
            connectionFactory.setChannelCacheSize(1);
            connectionFactory.setChannelCheckoutTimeout(2000);
            return connectionFactory;
        }

        @Bean
        RabbitTemplate rabbitTemplate(@Qualifier("publisherConnectionFactory") CachingConnectionFactory publisherConnectionFactory)
        {
            return new RabbitTemplate(publisherConnectionFactory);
        }

        @Bean
        SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(@Qualifier("connectionFactory") CachingConnectionFactory connectionFactory)
        {
            SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
            factory.setConnectionFactory(connectionFactory);
            return factory;
        }

        @Bean
        RabbitAdmin rabbitAdmin(@Qualifier("publisherConnectionFactory") CachingConnectionFactory publisherConnectionFactory)
        {
            return new RabbitAdmin(publisherConnectionFactory);
        }

        @RabbitListener(queuesToDeclare = @Queue("testQueue"))
        void consume(String payload)
        {
            this.received.add(payload);
        }
    }
}
