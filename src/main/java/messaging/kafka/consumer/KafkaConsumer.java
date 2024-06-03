package messaging.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import messaging.kafka.payload.Student;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

//    @KafkaListener(topics = "topic1",groupId = "myGroup")
    public void consumeMessage(String message){
        log.info(String.format("This is message to be consumed:::::........ %s",message));

    }

    @KafkaListener(topics = "topic1",groupId = "myGroup")
    public void consumeJsonMessage(Student message){
        log.info(String.format("This is message to be consumed:::::........ %s",message));

    }
}
