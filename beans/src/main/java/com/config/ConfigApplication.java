package com.config;

import com.model.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@ComponentScan({"com"})
@SpringBootApplication //equals to @Configuration, @EnableAutoConfiguration, @ComponentScan
public class ConfigApplication {

    @Bean("person") //Specifies specific bean name
    public Person fooPerson() {
        return Person.builder()
                .firstName("Jane")
                .lastName("Doe")
                .age(33)
                .build();
    }

    public static void main(String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(ConfigApplication.class);
        final String[] beanNames = context.getBeanDefinitionNames();

        // Displays all the beans from component scan
        Arrays.stream(beanNames)
                .sorted()
                .forEach(System.out::println);

        // Displays specific bean
        final Person person = context.getBean("person", Person.class);
        System.out.println(person);

    }

}
