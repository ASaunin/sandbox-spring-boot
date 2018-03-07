package com.asaunin.xml.basic.beans;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Contact {

    private Type type;
    private String value;

    public static enum Type {
        ADDRESS, EMAIL, PHONE
    }

    public Contact(Type type, String value) {
        this.type = type;
        this.value = value;
    }

}
