package com.fs.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.fs")
@SpringBootApplication
public class FsApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FsApiApplication.class, args);
    }

}
