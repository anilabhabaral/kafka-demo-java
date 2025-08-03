package com.org.demo;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class Consumer {
    public static void main(String[] args) {

        String bootstrapServer = "127.0.0.1:9092";
        String groupId = "test-consumer-group";
        String topics = "test02";

        // Create Consumer Properties
        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        // Create Kafka Consumer
        KafkaConsumer<String, String> consumer =
                new KafkaConsumer<>(properties);

        // Subscribe Consumer to Topics
        consumer.subscribe(List.of(topics));

        // Poll the data
        while (true) {

            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));

            for (ConsumerRecord<String, String> record : records) {
                System.out.println(
                        "Key: " + record.key() +
                        ", Value: " + record.value() +
                        ", Partition: " + record.partition() +
                        ", Offset: " + record.offset()
                );
            }
        }
    }
}
