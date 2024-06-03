package messaging.kafka.rest;

import messaging.kafka.entity.Script;
import messaging.kafka.service.ScriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/script")
public class ScriptController {
    @Autowired
    private ScriptService scriptService;

    @GetMapping
    public List<Script> getAllScript(){
        return scriptService.getAllScripts();
    }

    @GetMapping("/{id}")
    public Optional<Script> getScript(@PathVariable Long id){
        return scriptService.getScriptById(id);
    }


}
