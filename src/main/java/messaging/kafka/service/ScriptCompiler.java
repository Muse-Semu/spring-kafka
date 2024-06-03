package messaging.kafka.service;



import org.springframework.stereotype.Service;

import javax.script.*;

@Service
public class ScriptCompiler {
    public boolean executeValidationScript(String script,String firstName) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("scala");

        String scalaScript = script + "\nvalidateFirstName(\"" + firstName + "\")";

        try {
            return (Boolean) engine.eval(scalaScript);
        } catch (ScriptException e) {
            e.printStackTrace();
            return false;
        }
    }

    }
