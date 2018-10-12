package com.cemoli.crnk.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.cemoli.crnk.repository")
public class Applicationbook {
    public static void main(String[] args) {
        SpringApplication.run(SpringCrnkAppConf.class,args);
    }
}
