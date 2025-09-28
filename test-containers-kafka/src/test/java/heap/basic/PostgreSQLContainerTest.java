package heap.basic;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.jupiter.api.Test;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.kafka.KafkaContainer;

import java.sql.SQLException;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import static java.util.UUID.randomUUID;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

// any annotation is a what for what?
//
// how to find the code related to handling this annotation?
//
// what does this annotation do instead of me?
@Testcontainers
class PostgreSQLContainerTest
{
    // how to find the code related to handling this annotation?
    // what does this annotation does instead of me?
    @Container
    private KafkaContainer kafka = new KafkaContainer("apache/kafka-native:3.8.0");

    @Test
    void exercise_design_reverse_engineering() throws SQLException
    {
        String topicName = "hello-world-topic" + randomUUID();
        String messageKey = "my-key" + randomUUID();
        String messageValue = "Hello, Kafka with Testcontainers!" + randomUUID();

        // 1. Produce a message
        try (KafkaProducer<String, String> producer = createProducer(kafka.getBootstrapServers()))
        {
            producer.send(new ProducerRecord<>(topicName, messageKey, messageValue));
            producer.flush();
        }

        try (KafkaConsumer<String, String> consumer = createConsumer(kafka.getBootstrapServers(), "test-group")) {
            consumer.subscribe(Collections.singletonList(topicName));
            var records = consumer.poll(Duration.ofSeconds(10)); // Poll for records for 10 seconds

            var record = records.iterator().next();
            assertThat(record.key(), equalTo(messageKey));
            assertThat(record.value(), equalTo(messageValue));
        }
    }

    private KafkaProducer<String, String> createProducer(String bootstrapServers)
    {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return new KafkaProducer<>(props);
    }

    private KafkaConsumer<String, String> createConsumer(String bootstrapServers, String groupId)
    {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest"); // Start consuming from the beginning
        return new KafkaConsumer<>(props);
    }
}
