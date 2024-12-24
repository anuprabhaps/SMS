package com.sms.service.Impl;
import com.sms.model.Student;
import com.sms.repository.ResultRepository;
import com.sms.service.ResultService;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.sms.model.Result;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ResultServiceImpl implements ResultService {
    public ResultRepository resultRepository;

    public ResultServiceImpl(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @Override
    public Result createResult(Result result) {
        return resultRepository.save(result);
    }

    @Override
    public Result getResultById(int id) {
        Optional<Result> optionalResult = resultRepository.findById(id);
        return optionalResult.get();
    }


//    @Override
//    public List<Result> getAllResult() {
//        return resultRepository.findAll();
//    }

    @Override
    public Result updateResult(Result result) {
        Result existingResult = resultRepository.findById(result.getId()).get();
        existingResult.setName(result.getName());
        existingResult.setGrades(result.getGrades());
        existingResult.setResult(result.getResult());
        Result updatedResult = resultRepository.save(existingResult);
        return updatedResult;
    }

    @Override
    public void deleteResult(int id) {
        resultRepository.deleteById(id);
    }

}
