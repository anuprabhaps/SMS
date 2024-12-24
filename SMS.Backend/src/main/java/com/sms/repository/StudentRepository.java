package com.sms.repository;

import com.sms.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    //@Query("SELECT u FROM Student u WHERE u.email=?1")
    Student findByEmail(String email);
    //Optional<Student> findOneByEmailAndPassword(String email, String password);
}
