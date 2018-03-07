package com.asaunin.config.db.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("componentDataSource")
@Profile("prod")
@ConfigurationProperties(prefix = "db")
public class OracleConfiguration extends DataSource {

}
