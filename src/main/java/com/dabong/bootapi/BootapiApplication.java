package com.dabong.bootapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@MapperScan(basePackages = "com.dabong.bootapi.**.dao")
public class BootapiApplication {
    public static void main(String[] args) {
        System.out.println("Hello Boot API!");
        SpringApplication.run(BootapiApplication.class, args);
    }
}
