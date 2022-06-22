package com.baixin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;

@SpringBootApplication

public class PrayblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrayblogApplication.class, args);
    }

}
