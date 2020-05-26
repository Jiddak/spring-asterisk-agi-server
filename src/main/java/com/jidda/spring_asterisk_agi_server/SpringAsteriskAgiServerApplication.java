package com.jidda.spring_asterisk_agi_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
public class SpringAsteriskAgiServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAsteriskAgiServerApplication.class, args);
    }


    //Stops server from instantly dying
    //If you have spring-web or similar then just remove
    @Bean
    CountDownLatch latch(){
        CountDownLatch latch = new CountDownLatch(1);
        new Thread(){
            @Override
            public synchronized void run() {
                try { latch.await();}
                catch (Exception ignore){}
            }
        }.start();
        return latch;
    }

}
