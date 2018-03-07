package com.asaunin.annotations.spel;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"com.asaunin.annotations.spel"})
public class AppConfig {

    public static void main(String[] args) {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        final Robot robot = (Robot) context.getBean("robot");
        robot.speak();
        context.close();
    }

}
