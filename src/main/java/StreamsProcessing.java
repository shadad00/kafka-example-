import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Predicate;

import java.util.Properties;

public class StreamsProcessing {
    public static void main(String[] args) {
        Properties properties = new Properties();
        //like a group id.
        properties.put(StreamsConfig.APPLICATION_ID_CONFIG,"STREAM");
        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        properties.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.StringSerde.class.getName());
        properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG,Serdes.StringSerde.class.getName());


        StreamsBuilder streamsBuilder = new StreamsBuilder();
        streamsBuilder.<String,String>stream("java-topic")
                .mapValues(value -> String.valueOf(value.length())).to("java-topic-output");
        KafkaStreams streams = new KafkaStreams(streamsBuilder.build(), properties);
        streams.start();



    }
}
