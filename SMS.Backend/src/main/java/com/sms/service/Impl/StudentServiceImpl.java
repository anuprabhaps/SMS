package com.sms.service.Impl;

import com.sms.exception.ResourceNotFound;
import com.sms.model.Student;
import com.sms.repository.StudentRepository;
import com.sms.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    public StudentRepository studentRepository;
    public PasswordEncoder passwordEncoder;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(int id) {
        Student optionalStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Student not exist", +id));
        return optionalStudent;
    }
    @Override
    public Student findStudentByEmail(String email) {
        return studentRepository.findByEmail(email);
    }



    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }


    @Override
    public Student updateStudent(Student student, int id) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Student not exist", +id));;
        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());
        existingStudent.setGender(student.getGender());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setAddress(student.getAddress());
        existingStudent.setPassword(student.getPassword());
        Student updatedStudent = studentRepository.save(existingStudent);
        return updatedStudent;
    }

    @Override
    public void deleteStudent(int id) {
        Student dl=studentRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Student not exist", +id));
        studentRepository.delete(dl);
    }


}



