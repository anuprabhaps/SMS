package com.sms.service;

import com.sms.model.Result;
import java.util.List;

public interface ResultService {
    Result createResult(Result result);
    Result getResultById(int id);
    //List<Result> getAllResult();
    Result updateResult(Result result);
    void deleteResult(int id);
}
