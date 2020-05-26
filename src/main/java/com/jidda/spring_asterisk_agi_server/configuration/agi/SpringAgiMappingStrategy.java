package com.jidda.spring_asterisk_agi_server.configuration.agi;

import com.jidda.spring_asterisk_agi_server.configuration.agi.annotations.AgiBean;
import org.asteriskjava.fastagi.AgiChannel;
import org.asteriskjava.fastagi.AgiRequest;
import org.asteriskjava.fastagi.AgiScript;
import org.asteriskjava.fastagi.MappingStrategy;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SpringAgiMappingStrategy implements MappingStrategy {

    private final Map<String,AgiScript> agiBeans;

    public SpringAgiMappingStrategy(ApplicationContext applicationContext) {
        agiBeans = new HashMap<>();
        for (Map.Entry<String, Object> entry : applicationContext.getBeansWithAnnotation(AgiBean.class).entrySet()){
            Object bean = entry.getValue();
            String scriptName = (bean.getClass().getAnnotation(AgiBean.class)).value();
            scriptName = scriptName.equals("") ? bean.getClass().getSimpleName() : scriptName;
            if(bean instanceof AgiScript) {
                if(agiBeans.containsKey(scriptName))
                    throw new IllegalArgumentException("More than one agiBean with name: " + scriptName +  "!");
                else
                    agiBeans.put(scriptName, (AgiScript)bean);
            }
            else {
                throw new IllegalArgumentException("Class : " + bean.getClass() + " must implement org.asteriskjava.fastagi.AgiScript interface");
            }
        }
    }

    public synchronized AgiScript determineScript(AgiRequest request, AgiChannel channel) {
        return agiBeans.get(request.getScript());
    }

}
