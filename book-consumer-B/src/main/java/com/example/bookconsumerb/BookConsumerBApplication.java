package com.example.bookconsumerb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BookConsumerBApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookConsumerBApplication.class, args);
    }

}
