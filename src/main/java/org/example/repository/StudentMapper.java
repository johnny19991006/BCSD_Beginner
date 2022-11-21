package org.example.repository;

import org.example.domain.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMapper {

    Student getStudentById(Long id);
    void create(Student student);
}
