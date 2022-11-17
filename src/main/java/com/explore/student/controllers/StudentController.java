package com.explore.student.controllers;


import com.explore.student.entities.StudentEntity;
import com.explore.student.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping(path="{studentId}")
    public StudentEntity getStudent(@PathVariable Long studentId){
        return  studentService.getStudent(studentId);
    }

    @GetMapping
    public List<StudentEntity > getStudents(){
       return  studentService.getStudents();
    }

    @PostMapping
    public ResponseEntity addStudent(@RequestBody StudentEntity student){
        return studentService.addStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public boolean addStudent(@PathVariable("studentId") Long studentId){
       return studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public StudentEntity updateStudent(@PathVariable("studentId") Long studentId, @RequestParam(required = false) String name, @RequestParam(required = false) String email){
        return studentService.updateStudent(studentId, name, email);
    }
}
