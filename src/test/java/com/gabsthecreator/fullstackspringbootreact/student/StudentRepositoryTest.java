package com.gabsthecreator.fullstackspringbootreact.student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository underTest;

    @Test
    void itShouldCheckIfStudentExistsByEmail() {

        // given
        String email = "gabsthesre@gmail.com";
        Student student = new Student("Bart the Shibb", email, Gender.MALE);
        underTest.save(student);

        // when
        Boolean emailExistsExpected =  underTest.selectExistsEmail(email);

        // then
        assertThat(emailExistsExpected).isTrue();

    }
}