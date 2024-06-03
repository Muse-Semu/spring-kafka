package messaging.kafka.service;

import messaging.kafka.entity.Script;
import messaging.kafka.repository.ScriptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScriptService {
    @Autowired
    private ScriptRepository scriptRepository;
    public List<Script> getAllScripts() {
        return scriptRepository.findAll();
    }


    public Optional<Script> getScriptById(Long id) {
        return scriptRepository.findById(id);
    }
}
