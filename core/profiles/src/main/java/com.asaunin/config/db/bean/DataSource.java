package com.asaunin.config.db.bean;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class DataSource {

    private String driver;
    private String url;
    private String username;
    private String password;

}
