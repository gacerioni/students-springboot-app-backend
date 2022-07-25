package com.gabsthecreator.fullstackspringbootreact.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gabsthecreator.fullstackspringbootreact.student.Gender;
import com.gabsthecreator.fullstackspringbootreact.student.Student;
import com.gabsthecreator.fullstackspringbootreact.student.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource(
        locations = "classpath:application-it.properties"
)
@AutoConfigureMockMvc
public class StudentIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void canRegisterNewStudent() throws Exception {
        // given
        String email = "lol2@gmail.com";
        Student student = new Student("Bart the Shibb", email, Gender.MALE);

        // when
        ResultActions resultActions = mockMvc
                .perform(post("/api/v1/students")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(student)));

        //then
        resultActions.andExpect(status().isOk());
        List<Student> studentList = studentRepository.findAll();
        assertThat(studentList).usingElementComparatorIgnoringFields("id").contains(student);

    }

}
