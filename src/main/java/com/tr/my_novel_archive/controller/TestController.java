package com.tr.my_novel_archive.controller;

import com.tr.my_novel_archive.model.Test;
import com.tr.my_novel_archive.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class TestController {

    private TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/test")
    public ResponseEntity<String> get(){
        return new ResponseEntity<>("Test", HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Test> save(@RequestBody Test test) {
        try{
            test = testService.save(test);
            return new ResponseEntity<>(test, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Test> get(@PathVariable Long id){
        Test test = testService.get(id);
        if(test == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(test, HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Test>> getAll(){
        List<Test> test = testService.get();
        if(test == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(test, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Test> update(@RequestBody Test test){
        if(test.getId() ==null || testService.get(test.getId()) == null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        testService.update(test);
        return  new ResponseEntity<>(null, HttpStatus.OK);

    }
}
