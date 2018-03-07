package com.asaunin;

import com.asaunin.domain.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication //equals to @Configuration, @EnableAutoConfiguration, @ComponentScan
public class BeansApplication {

    @Bean("person") //Specifies specific bean name
    public Person fooPerson() {
        return Person.builder()
                .firstName("Jane")
                .lastName("Doe")
                .age(33)
                .build();
    }

    public static void main(String[] args) {
        final ApplicationContext context = SpringApplication.run(BeansApplication.class);
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
