package com.message.sendmessage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@MapperScan(basePackages = "com.message.sendmessage.mapper")
public class SendMessageApplication {

    public static void main(String[] args) {
        SpringApplication.run(SendMessageApplication.class, args);
    }

}
