package com.sms.service;

import com.sms.model.Courses;
import com.sms.model.Result;

import java.util.List;

public interface CourseService {
    Courses createCourse(Courses course);
    Courses getCourseById(int id);
    List<Courses> getAllCourse();
    Courses updateCourse(Courses course);
    void deleteCourse(int id);
}
