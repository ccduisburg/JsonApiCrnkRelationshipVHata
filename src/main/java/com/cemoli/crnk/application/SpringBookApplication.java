package com.cemoli.crnk.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan("com.cemoli.crnk.repository")
@SpringBootApplication
public class SpringBookApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCrnkAppConf.class,args);
    }
}
