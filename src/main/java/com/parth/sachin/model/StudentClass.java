package com.parth.sachin.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class StudentClass {


    List<Student> allStudents = new ArrayList<>();

    public StudentClass () {
        allStudents.add(new Student("sachin"));
        allStudents.add(new Student("Praveen"));
        allStudents.add(new Student("Avinash"));

    }

    public List<Student> getStudents() {
        return allStudents;
    }

    public boolean addStudent(Student newStudent) {
        allStudents.add(newStudent);
        return true;
    }


}
