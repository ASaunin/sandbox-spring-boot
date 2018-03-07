package com.asaunin.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter @Setter
@EqualsAndHashCode(exclude = {"id"})
@ToString(of = {"title"})
public class Post {

    private long id;
    private Person author;
    private String title;
    private String body;
    private String description;
    private Date postedOn;

    // Just a stub setter to prevent too much coding in example
    public void setAuthor(int id) {
        this.author = new Person("John", "Doe", "johndoe","john.doe@gmail.com");
    }

}
