package com.parth.sachin.controller;

import com.parth.sachin.model.Student;
import java.util.*;

import com.parth.sachin.model.StudentClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    StudentClass students;

    @GetMapping("/")
    public List<Student> getStudents() {
        return students.getStudents();
    }

    @PostMapping("/add")
    public boolean addStudent(@RequestBody Student student) {
        return students.addStudent(student);
    }
}
