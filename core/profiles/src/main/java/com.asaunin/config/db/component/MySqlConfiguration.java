package com.asaunin.config.db.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("componentDataSource")
@Profile("dev")
@ConfigurationProperties(prefix = "db")
public class MySqlConfiguration extends DataSource {

}
