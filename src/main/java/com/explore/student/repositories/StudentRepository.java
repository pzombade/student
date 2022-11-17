package com.explore.student.repositories;

import com.explore.student.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    @Query("SELECT s FROM StudentEntity s where s.email = ?1")
    Optional<StudentEntity> findStudentByEmail(String email);

    @Query("SELECT s FROM StudentEntity s where s.id = ?1")
    Optional<StudentEntity> findStudentById(Long id);
}
