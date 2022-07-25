package com.gabsthecreator.fullstackspringbootreact.integration;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(
        locations = "classpath:application-it.properties"
)
public class StudentIT {

    @Test
    void name(){

    }

}
