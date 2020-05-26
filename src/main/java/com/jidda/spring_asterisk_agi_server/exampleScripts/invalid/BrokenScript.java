package com.jidda.spring_asterisk_agi_server.exampleScripts.invalid;

import com.jidda.spring_asterisk_agi_server.configuration.agi.annotations.AgiBean;
import org.springframework.stereotype.Component;

@Component
@AgiBean
//Doesn't extend BaseAgi so it is time for it to die
//Delete for app to run
public class BrokenScript {
}
