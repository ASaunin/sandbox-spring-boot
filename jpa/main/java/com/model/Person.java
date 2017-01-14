package com.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "persons")
@Getter @Setter
@EqualsAndHashCode(exclude = {"id"})
public class Person {

    @Id @GeneratedValue
    private long id;
    private String email;
    private String firstName;
    private String lastName;
    private String name;
    private String sex;

}
