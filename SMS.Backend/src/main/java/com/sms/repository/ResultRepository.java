package com.sms.repository;

import com.sms.model.Result;
import com.sms.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result, Integer> {

}
