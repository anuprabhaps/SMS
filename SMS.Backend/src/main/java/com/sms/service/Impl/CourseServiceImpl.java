package com.sms.service.Impl;
import com.sms.model.Courses;
import com.sms.repository.CourseRespository;
import com.sms.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    public CourseServiceImpl(CourseRespository courseRespository) {
        this.courseRespository = courseRespository;
    }
    public CourseRespository courseRespository;

    @Override
    public Courses createCourse(Courses course) {
        return courseRespository.save(course);
    }

    @Override
    public Courses getCourseById(int id) {
        Optional<Courses> OptionalCourse=courseRespository.findById(id);
        return OptionalCourse.get();
    }

    @Override
    public List<Courses> getAllCourse() {
        return courseRespository.findAll();
    }

    @Override
    public Courses updateCourse(Courses course) {
        Courses existingCourse = courseRespository.findById(course.getId()).get();
        existingCourse.setName(course.getName());
        existingCourse.setCode(course.getCode());
        existingCourse.setSem_no(course.getSem_no());
        Courses updatedCourse = courseRespository.save(existingCourse);
        return updatedCourse;
    }

    @Override
    public void deleteCourse(int id) {
        courseRespository.deleteById(id);
    }
}
