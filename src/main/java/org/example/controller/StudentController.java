package org.example.controller;

import org.example.domain.Student;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping()
    public String createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
        return "create User";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student studentInfo(@PathVariable("id") Long id) {
        return studentService.getStudentInfo(id);
    }
}


