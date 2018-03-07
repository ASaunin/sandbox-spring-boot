package com.asaunin.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "config")
@Getter
@Setter
@ToString
public class Configuration {

    private String appName;
    private String appDescription;
    private String adminFirstName;
    private String adminLastName;
    private String adminEmail;

}
