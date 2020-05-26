package com.jidda.spring_asterisk_agi_server.exampleScripts.invalid;

import com.jidda.spring_asterisk_agi_server.configuration.agi.annotations.AgiBean;
import org.asteriskjava.fastagi.AgiChannel;
import org.asteriskjava.fastagi.AgiException;
import org.asteriskjava.fastagi.AgiRequest;
import org.asteriskjava.fastagi.BaseAgiScript;
import org.springframework.stereotype.Component;

@Component
@AgiBean("duplicate")
public class DuplicateScript2 extends BaseAgiScript {

    public void service(AgiRequest request, AgiChannel channel)
            throws AgiException
    {
        answer();
    }
}
