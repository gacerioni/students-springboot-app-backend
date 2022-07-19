package com.gabsthecreator.fullstackspringbootreact.student;


import com.gabsthecreator.fullstackspringbootreact.student.exception.BadRequestException;
import com.gabsthecreator.fullstackspringbootreact.student.exception.StudentNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        Boolean existsEmail = studentRepository.selectExistsEmail(student.getEmail());
        if (existsEmail) {
            throw new BadRequestException(
                    "Sorry, the E-Mail " + student.getEmail() + " is already taken. Please use another one."
            );
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        if (!studentRepository.existsById(studentId)) {
            throw new StudentNotFoundException(
                    "Sorry, a Student with ID " + studentId + " does not exist."
            );
        }


        studentRepository.deleteById(studentId);
    }
}
