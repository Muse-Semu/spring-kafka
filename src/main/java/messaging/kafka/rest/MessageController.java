package messaging.kafka.rest;

import lombok.RequiredArgsConstructor;
import messaging.kafka.entity.Script;
import messaging.kafka.payload.Student;
import messaging.kafka.producer.KafkaJsonProducer;
import messaging.kafka.producer.KafkaProducer;
import messaging.kafka.repository.ScriptRepository;
import messaging.kafka.service.ScriptCompiler;
import messaging.kafka.service.ScriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/message")
@RequiredArgsConstructor
public class MessageController {
    private final KafkaProducer kafkaProducer;

    private final KafkaJsonProducer kafkaJsonProducer;

    @Autowired
    private final ScriptCompiler scriptCompiler;

    @Autowired
    private final ScriptService scriptService;

    private Optional<Script> script;

    @PostMapping
    public ResponseEntity<?> sendMessage(@RequestBody String message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message queued successfully! ");
    }

    @PostMapping("/json")
    public ResponseEntity<String> sendJsonMessage(@RequestBody Student student){
        script = scriptService.getScriptById(1L);
        if(script.isPresent()){
            if(scriptCompiler.executeValidationScript(script.get().getScript(),student.getFirstName())){
                kafkaJsonProducer.sendMessage(student);
                return ResponseEntity.ok("Json Message send Successfully");
            }
            else {
                return ResponseEntity.badRequest().body("First name is not valid");
            }
        }


        return ResponseEntity.badRequest().body("Message is not sent");
    }


}
