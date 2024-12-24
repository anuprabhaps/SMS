package com.sms;
import com.sms.model.Courses;
import com.sms.model.Result;
import com.sms.model.Student;
import com.sms.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
    @Test
    public void testCreateStudent() {
        Student student= new Student();
        student.setAddress("Chennai");
        student.setAge(26);
        student.setEmail("surya@gmail.com");
        student.setGender('M');
        student.setName("Surya");
        student.setPassword("s@uyA");
        Courses course=new Courses();
        course.setName("Machine learning");
        course.setCode(121);
        course.setSem_no(2);
        student.getCourse().add(course);
        course.getStudent().add(student);

        Result result=new Result();
        result.setName("Machine learning");
        result.setGrades("A");
        result.setResult("PASS");
        student.getResult().add(result);
        Student savedStudent = studentRepository.save(student);
        assertNotNull(savedStudent);
        assertThat(student.getId()).isGreaterThan(0);
        assertEquals("Surya", savedStudent.getName());
    }
    @Test
    public void testgetStudentById(){

        Student student = studentRepository.findById(1).get();

        assertThat(student.getId()).isEqualTo(1);

    }
    @Test
    public void getListOfStudentTest(){

        List<Student> student = studentRepository.findAll();

        assertThat(student.size()).isGreaterThan(0);

    }
    @Test
    public void updateStudentTest(){

        Student student = studentRepository.findById(1).get();

        student.setEmail("anuprabha@gmail.com");

        Student studentUpdated =  studentRepository.save(student);

        assertThat(studentUpdated.getEmail()).isEqualTo("anuprabha@gmail.com");

    }
    @Test
    public void testDeleteStudent() {
        Student student = studentRepository.findById(1).get();
        studentRepository.deleteById(student.getId());
        Student dele = studentRepository.findById(student.getId()).orElse(null);
        assertNull(dele);
    }

}