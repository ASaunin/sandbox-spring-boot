package com.asaunin.domain;

import lombok.Builder;
import lombok.NonNull;
import lombok.ToString;

@Builder
@ToString
public class Person {

    @NonNull private String firstName;
    @NonNull private String lastName;
    private int age;

}