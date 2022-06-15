package com.zsl.easyexcelpro.controller;


import com.zsl.easyexcelpro.model.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api")
@RestController
public class TestController {

    public static final List<Student> students = new ArrayList<>();

    static {
        students.add(new Student("zhangsan", 17));
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }

    @GetMapping("/name")
    public String name(@RequestParam("name") String name) {
        return "name:" + name;
    }

    @PostMapping("/add")
    public List<Student> add(@RequestBody Student student) {
        students.add(student);
        return students;
    }
}

