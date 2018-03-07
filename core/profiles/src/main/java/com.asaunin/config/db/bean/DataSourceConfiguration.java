package com.asaunin.config.db.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

@Configuration
public class DataSourceConfiguration {

    private Environment env;

    @Autowired
    public DataSourceConfiguration(Environment env) {
        this.env = env;
    }

    @Bean(name = "beanDataSource")
    @Profile("dev")
    public DataSource development() {
        return DataSource.builder()
                .driver(env.getProperty("db.driver"))
                .url(env.getProperty("db.url"))
                .username("John")
                .password("foo")
                .build();
    }

    @Bean(name = "beanDataSource")
    @Profile("prod")
    public DataSource production() {
        return DataSource.builder()
                .driver(env.getProperty("db.driver"))
                .url(env.getProperty("db.url"))
                .username("Jane")
                .password("bar")
                .build();
    }

}