package com.tr.my_novel_archive.service;

import com.tr.my_novel_archive.model.Test;
import com.tr.my_novel_archive.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TestService {

    TestRepository testRepository;

    @Autowired
    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public Test save(Test test){
        return testRepository.save(test);
    }

    public Test get(Long id){
        return testRepository.getOne(id);
    }

    public List<Test> get(){
        return testRepository.findAll();
    }

    public void update(Test test){
        testRepository.save(test);
    }


}
