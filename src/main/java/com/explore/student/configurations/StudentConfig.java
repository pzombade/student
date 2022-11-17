package com.explore.student.configurations;

import com.explore.student.entities.StudentEntity;
import com.explore.student.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            StudentEntity prashant =  new StudentEntity(1L, "Prashant1", "p@z.com", LocalDate.of(1986,5,20));
        StudentEntity who =  new StudentEntity(2L, "Peppa", "Peppa@who.com", LocalDate.of(2020,11,22));

        studentRepository.saveAll(List.of(prashant, who));
        };
    }
}
