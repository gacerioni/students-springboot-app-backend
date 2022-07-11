package com.gabsthecreator.fullstackspringbootreact.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {


    @GetMapping
    public List<Student> getAllStudents() {
        List<Student> students = Arrays.asList(
                new Student(1L, "Gabs the Creator", "gacerioni@gmail.com", Gender.MALE),
                new Student(2L, "Cintia the Master", "cintiafake@gmail.com", Gender.FEMALE),
                new Student(3L, "Felipe the Sage", "fliplume@gmail.com", Gender.NONBINARY)
        );

        return students;
    }
}
