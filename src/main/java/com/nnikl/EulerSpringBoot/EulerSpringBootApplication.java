package com.nnikl.EulerSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication

public class EulerSpringBootApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(EulerSpringBootApplication.class, args);
        var euler7 = context.getBean(Euler7.class);
        System.out.println("Result: " + euler7.solveEuler7());
    }
}
