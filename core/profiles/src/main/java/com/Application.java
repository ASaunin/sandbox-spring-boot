package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        final ApplicationContext context = SpringApplication.run(Application.class, args);

        System.out.println("\nProfile properties example via components: " + context.getBean("componentDataSource"));

        System.out.println("\nProfile properties example via beans: " + context.getBean("beanDataSource"));

        System.out.println("\nEnvironment properties example using conditional annotation: " + context.getBean("emailService"));

    }


}
