package com.message.sendmessage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SendMessageApplication {

    public static void main(String[] args) {
        SpringApplication.run(SendMessageApplication.class, args);
    }

}
