package com.jidda.spring_asterisk_agi_server.exampleScripts.valid;

import com.jidda.spring_asterisk_agi_server.configuration.agi.annotations.AgiBean;
import org.asteriskjava.fastagi.AgiChannel;
import org.asteriskjava.fastagi.AgiException;
import org.asteriskjava.fastagi.AgiRequest;
import org.asteriskjava.fastagi.BaseAgiScript;
import org.springframework.stereotype.Component;

@Component
@AgiBean
//Will use ExampleScript as name
//I.e
//AGI(agi://server/ExampleScript)
public class ExampleScript extends BaseAgiScript {

    public void service(AgiRequest request, AgiChannel channel)
            throws AgiException
    {
        try {
            answer();
            streamFile("welcome");
        } catch (org.asteriskjava.fastagi.AgiHangupException e) {
            System.out.println("the user hung up!");
        }
    }

}
