package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student mariam = new Student(
                    1L,
                    "Mariam",
                    "mariam.jama@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );

            Student daniel = new Student(
                    2L,  // Muutin ID:n arvoksi 2L, jotta vältetään saman ID:n käyttö
                    "Daniel",
                    "daniel.daniel@gmail.com",
                    LocalDate.of(1999, Month.FEBRUARY, 20)
            );

            studentRepository.saveAll(
                    List.of(mariam, daniel)
            );
        };
    }
}
