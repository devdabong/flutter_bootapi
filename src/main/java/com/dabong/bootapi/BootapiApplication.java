package com.dabong.bootapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootapiApplication {
    public static void main(String[] args) {
        System.out.println("Hello Boot API!");
        SpringApplication.run(BootapiApplication.class, args);
    }
}
