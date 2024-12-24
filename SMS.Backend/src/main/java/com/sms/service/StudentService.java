package com.sms.service;

import com.sms.model.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);
    Student getStudentById(int id);
    List<Student> getAllStudent();

    Student updateStudent(Student student, int id);

    void deleteStudent(int id);
    Student findStudentByEmail(String email);

}
