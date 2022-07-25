package com.gabsthecreator.fullstackspringbootreact.student;


import com.gabsthecreator.fullstackspringbootreact.student.exception.BadRequestException;
import com.gabsthecreator.fullstackspringbootreact.student.exception.StudentNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    @Transactional
    public void updateStudent(Long studentId, String name, String email, Gender gender) {

        // Check if student exists
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("Student with ID " + studentId + " does not exist!");
        }
        Student student = studentRepository.findById(studentId).orElseThrow();
        System.out.println("Student to be updated was found!");
        System.out.println(student);

        // Name does not need to be unique, so this is a simple set(), that will auto-update via DML
        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            System.out.println("Condition satisfied!");
            System.out.println("Old Name: " + student.getName());
            System.out.println("New Name: " + name);
            student.setName(name);
        }

        // This is a bit trickier, because we must check if the e-mail is not taken by another student.
        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {

            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("This email " + email + " is already taken!");
            }

            student.setEmail(email);
        }

        // Gender is an enum, but this should not be a big deal.
        if (gender != null && !Objects.equals(student.getGender(), gender)) {
            student.setGender(gender);
        }


    }
}
