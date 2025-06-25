package com.sshukla7527.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class SpringBootMicroservicesApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootMicroservicesApplication.class, args);
    }
}