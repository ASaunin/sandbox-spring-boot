package com;

import com.config.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ConfigPropertiesApplication {

    public static void main(String[] args) {
        final ApplicationContext context = SpringApplication.run(ConfigPropertiesApplication.class, args);
        final Configuration config = (Configuration) context.getBean("configuration");

        System.out.println(config);
    }

}
