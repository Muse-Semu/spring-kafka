package messaging.kafka.rest;

import lombok.RequiredArgsConstructor;
import messaging.kafka.producer.KafkaProducer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/message")
@RequiredArgsConstructor
public class MessageController {
    private final KafkaProducer kafkaProducer;
}
