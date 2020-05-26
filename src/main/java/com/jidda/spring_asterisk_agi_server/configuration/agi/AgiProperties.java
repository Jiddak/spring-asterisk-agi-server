package com.jidda.spring_asterisk_agi_server.configuration.agi;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "asterisk.agi")
public class AgiProperties {
    Integer port;

    public void setPort(Integer port){
        this.port = port;
    }

    public Integer getPort() {
        return port;
    }
}
