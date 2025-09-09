package com.nnikl.EulerSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EulerSpringBootApplication {

	public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(EulerSpringBootApplication.class, args);
        var euler6 = context.getBean(Euler6.class);
        euler6.sumSquaresResult();
        System.out.println(euler6.sumSquaresResult());
	}

}
