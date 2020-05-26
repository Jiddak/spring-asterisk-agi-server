package com.jidda.spring_asterisk_agi_server.configuration.agi;

import org.asteriskjava.fastagi.AgiServerThread;
import org.asteriskjava.fastagi.DefaultAgiServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AgiConfig {

    @Bean
    public AgiServerThread agiServerThread(AgiProperties agiConfigProperties,SpringAgiMappingStrategy springAgiMappingStrategy){
        DefaultAgiServer agiServer = new DefaultAgiServer(springAgiMappingStrategy);
        agiServer.setPort(agiConfigProperties.getPort());
        AgiServerThread agiServerThread = new AgiServerThread(agiServer);
        agiServerThread.startup();
        return agiServerThread;
    }

}
