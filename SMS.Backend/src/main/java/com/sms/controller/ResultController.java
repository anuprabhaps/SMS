package com.sms.controller;

import com.sms.model.Result;
import com.sms.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RequestMapping("/result")
@RestController
public class ResultController {
    @Autowired
    private ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }
    @PostMapping
    public ResponseEntity<Result> createResult(@RequestBody Result result){
        Result savedResult = resultService.createResult(result);
        return new ResponseEntity<>(savedResult, HttpStatus.CREATED);
    }

    // build get user by id REST API

    @GetMapping("/{id}")
    public ResponseEntity<Result> getResultById(@PathVariable("id") int id){
        Result result = resultService.getResultById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    //get All student
//    @GetMapping
//    public ResponseEntity<List<Result>> getAllResult(){
//        List<Result> result = resultService.getAllResult();
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }

    // Build Update User REST API
    @PutMapping("/{id}")
    public ResponseEntity<Result> updateResult(@PathVariable("id") int id,
                                                 @RequestBody Result result){
        result.setId(id);
        Result updatedResult = resultService.updateResult(result);
        return new ResponseEntity<>(updatedResult, HttpStatus.OK);
    }

    // Build Delete User REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteResult(@PathVariable("id") int id){
        resultService.deleteResult(id);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }

}
