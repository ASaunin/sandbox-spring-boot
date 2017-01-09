package com.config.db.component;

import lombok.Data;

@Data
public abstract class DataSource {

    private String driver;
    private String url;
    private String username;
    private String password;

}
