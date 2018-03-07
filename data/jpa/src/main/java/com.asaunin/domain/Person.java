package com.asaunin.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Formula;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "persons")
@Getter @Setter
@EqualsAndHashCode(exclude = {"id"})
@ToString(of = {"fullName"})
public class Person {

    @Id @GeneratedValue
    private long id;

    private String email;

    private String nickName;

    private String firstName;

    private String lastName;

    @Formula(value = "concat(first_name, ' ', last_name)")
    private String fullName;

    private String sex;

}
