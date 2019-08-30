package com.parth.sachin.model;

import org.springframework.stereotype.Component;

@Component
public class Student {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(String name) {
        this.name = name;
    }

    public Student() {

    }
}
