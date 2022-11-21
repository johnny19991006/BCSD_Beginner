package org.example.service;

import org.example.domain.Student;
import org.example.repository.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentMapper studentMapper;

    @Autowired
    public StudentServiceImpl(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public Student getStudentInfo(long id) {
        return studentMapper.getStudentById(id);
    }

    public void createStudent(Student student) {
        studentMapper.create(student);
    }
}

