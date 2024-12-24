package com.sms;
import com.sms.model.Courses;
import com.sms.model.Result;
import com.sms.model.Student;
import com.sms.repository.StudentRepository;
import static org.assertj.core.api.Assertions.assertThat;
import com.sms.service.Impl.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    public Student student;



    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllStudent(){

        Student student = new Student();
        student.setAddress("Chennai");
        student.setAge(26);
        student.setEmail("surya@gmail.com");
        student.setGender('M');
        student.setName("Surya");
        student.setPassword("s@uyA");
        Courses course = new Courses();
        course.setName("Machine learning");
        course.setCode(121);
        course.setSem_no(2);
        student.getCourse().add(course);
        course.getStudent().add(student);

        Result result = new Result();
        result.setName("Machine learning");
        result.setGrades("A");
        result.setResult("PASS");
        student.getResult().add(result);
        List<Student> list = new ArrayList<Student>();
        when(studentRepository.findAll()).thenReturn(list);
        List<Student> stdList = studentService.getAllStudent();

        // then - verify the output
        assertThat(stdList).isEmpty();
        assertThat(stdList.size()).isEqualTo(0);
        verify(studentRepository, times(1)).findAll();
    }

    @Test
    public void CreateStudent(){
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

        //Student studentUpdated =  studentRepository.save(student);
        // given - precondition or setup
        when(studentRepository.save(student)).thenReturn(student);
        // when -  action or the behaviour that we are going test
         studentService.createStudent(student);

        // then - verify the output
        verify(studentRepository, times(1)).save(student);

    }


}
