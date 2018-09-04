package kafka;

/*
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.HashMap;
import java.util.Map;
*/

public class MessageProducer {
    public static void main(String[] args) {
/*
        Map<String, Object> config = new HashMap<String, Object>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        config.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(config);

        int maxMessages = 1000;

        int count = 0;
        while(count < maxMessages) {
            producer.send(new ProducerRecord<String, String>("testTopic", "msg", "message --- #"+count++));
            System.out.println("Message send.."+count);
        }
*/
    }
}