package com.sms.controller;
import com.sms.model.Courses;
import com.sms.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/course")
@RestController

public class CourseController {
    @Autowired
    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @PostMapping
    public ResponseEntity<Courses> createCourse(@RequestBody Courses course){
        Courses savedCourse = courseService.createCourse(course);
        return new ResponseEntity<>(savedCourse, HttpStatus.CREATED);
    }

    // build get user by id REST API

    @GetMapping("/{id}")
    public ResponseEntity<Courses> getCourseById(@PathVariable("id") int id){
        Courses course = courseService.getCourseById(id);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }


    //get All student
    @GetMapping
    public ResponseEntity<List<Courses>> getAllCourse(){
        List<Courses> course = courseService.getAllCourse();
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    // Build Update User REST API
    @PutMapping("/{id}")
    public ResponseEntity<Courses> updateCourse(@PathVariable("id") int id,
                                               @RequestBody Courses course){
        course.setId(id);
        Courses updatedCourse = courseService.updateCourse(course);
        return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
    }

    // Build Delete User REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable("id") int id){
        courseService.deleteCourse(id);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }

}
