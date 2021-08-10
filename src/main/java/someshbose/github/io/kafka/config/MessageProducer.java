package someshbose.github.io.kafka.config;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
//import someshbose.github.io.kafka.AppConfigs;

import java.util.Properties;

@Service
public class MessageProducer {

    private static final Logger logger = LogManager.getLogger();

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    private Environment env;

    @Bean
    public void send() {

      //  logger.info("Creating Kafka Producer...");
    //    Properties props = getProperties();

      //  KafkaProducer<Integer, String> producer = new KafkaProducer<>(props);

        logger.info("Start sending messages...");
        for (int i = 1; i <= 10;i++){//AppConfigs.numEvents; i++) {
            //producer.send(new ProducerRecord<>(AppConfigs.topicName, i, "Simple Message-" + i));
            kafkaTemplate.send(createMessage("Simple Message-" + i));
        }

        logger.info("Finished - Closing Kafka Producer.");
       // producer.close();

    }

    private Message createMessage(String msg){
        return MessageBuilder.withPayload(msg)
            .setHeader(KafkaHeaders.TOPIC, env.getProperty("kafka.topic-name"))
            .setHeader(KafkaHeaders.MESSAGE_KEY , msg)
            .build();
    }

//    private Properties getProperties(){
//        Properties props = new Properties();
//        props.put(ProducerConfig.CLIENT_ID_CONFIG, AppConfigs.producerApplicationID);
//        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConfigs.bootstrapServers);
//        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class.getName());
//        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
//        return props;
//    }

}
