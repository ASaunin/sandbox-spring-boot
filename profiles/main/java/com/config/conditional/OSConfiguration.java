package com.config.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OSConfiguration {

    @Bean(name="emailService")
    @Conditional(WindowsCondition.class)
    public String windowsEmailService(){
        return "Windows email service";
    }

    @Bean(name="emailService")
    @Conditional(LinuxCondition.class)
    public String linuxEmailService(){
        return "Linux email service";
    }

}
