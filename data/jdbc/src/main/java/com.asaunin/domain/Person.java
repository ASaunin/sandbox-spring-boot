package com.asaunin.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@EqualsAndHashCode(exclude = {"nickName"})
@ToString(of = {"fullName"})
public class Person {

    private long id;
    private String email;
    private String nickName;
    private String firstName;
    private String lastName;
    private String fullName;
    private String sex;

    public Person(String firstName, String lastName, String nickName, String email) {
        this.email = email;
        this.nickName = nickName;
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public Person() {

    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        setFullName();
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        setFullName();
    }

    private void setFullName() {
        this.fullName = this.firstName + " " + this.lastName;
    }

}
