package com.jidda.spring_asterisk_agi_server.exampleScripts.valid;

import com.jidda.spring_asterisk_agi_server.configuration.agi.annotations.AgiBean;
import org.asteriskjava.fastagi.AgiChannel;
import org.asteriskjava.fastagi.AgiException;
import org.asteriskjava.fastagi.AgiRequest;
import org.asteriskjava.fastagi.BaseAgiScript;
import org.springframework.stereotype.Component;

@Component
@AgiBean("MonkeyScript")
//Will use Annotation as name
//I.e
//AGI(agi://server/MonkeyScript)
public class NamedScript extends BaseAgiScript {

    public void service(AgiRequest request, AgiChannel channel)
            throws AgiException
    {
        try {
            answer();
            streamFile("tt-monkeys");
        } catch (org.asteriskjava.fastagi.AgiHangupException e) {
            System.out.println("the user hung up!");
        }
    }

}
