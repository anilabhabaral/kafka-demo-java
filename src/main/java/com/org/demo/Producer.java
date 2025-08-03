package com.org.demo;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class Producer {

    public static void main(String[] args) throws InterruptedException {

        String bootstrapServer = "127.0.0.1:9092";

        // Create Producer Properties
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // Create the Producer
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        // Create a Producer Record
        int i=1;
        while (i!=10) {
            ProducerRecord<String, String> record = new ProducerRecord<>("test02", "hello from java client producer: "+i);
            producer.send(record);
            Thread.sleep(1000);
            i++;
        }

        // Flush and Close the Producer
        producer.flush();
        producer.close();

    }
}
