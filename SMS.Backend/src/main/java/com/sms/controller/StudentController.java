package com.sms.controller;
import com.sms.model.Student;
import com.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/student")
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student savedStudent = studentService.createStudent(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    // build get user by id REST API

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") int id){
        Student student = studentService.getStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }



//get All student
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> student = studentService.getAllStudent();
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    // Build Update User REST API
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") int id,
                                                 @RequestBody Student student){
        student.setId(id);
        Student updatedStudent = studentService.updateStudent(student,id);
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }

    // Build Delete User REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }

}