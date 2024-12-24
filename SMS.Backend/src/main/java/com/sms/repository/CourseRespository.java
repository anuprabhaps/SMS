package com.sms.repository;

import com.sms.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRespository extends JpaRepository<Courses,Integer> {
    //List<Courses>findstudentBySem(Integer sem_no);
}
