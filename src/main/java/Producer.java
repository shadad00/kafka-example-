import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class Producer {
    //Connect to kafka cluster and send messages
    //topic must be created before insertions.

    public static void main(String[] args) {
        final Logger logger = LoggerFactory.getLogger(Producer.class);

        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());

        final KafkaProducer<String,String> producer = new KafkaProducer<>(properties);

        for (int i = 0; i < 10 ; i++) {

            ProducerRecord<String,String> record = new ProducerRecord<>("java-topic","key_"+i,"value_"+i);

            producer.send(record, (recordMetadata, e) -> {
                if(e==null){
                    logger.info("\n Received record metadata Topic: "+recordMetadata.topic()+" ,Partition "+
                            recordMetadata.partition()+", Offset:"+recordMetadata.offset()+"\n");
                }else {
                    logger.error("Error occurred",e);
                }
            });
        }


        producer.flush();
        producer.close();

    }

}
