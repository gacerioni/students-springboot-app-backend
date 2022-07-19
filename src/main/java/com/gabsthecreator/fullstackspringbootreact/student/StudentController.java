package com.gabsthecreator.fullstackspringbootreact.student;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;


    @GetMapping
    public List<Student> getAllStudents() {
        //throw new IllegalStateException("vish");
        return studentService.getAllStudents();
    }

    @PostMapping
    public void addStudent(@Valid @RequestBody Student student){
        studentService.addStudent(student);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        // check if user exists later!
        studentService.deleteStudent(studentId);
    }
}
