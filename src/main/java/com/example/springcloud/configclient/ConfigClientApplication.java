package com.example.springcloud.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ConfigClientApplication {

    @Value("${testinfo.name}")
    String name;
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

}
