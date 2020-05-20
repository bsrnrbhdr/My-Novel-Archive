package com.tr.MNA.Service;

import com.tr.MNA.Model.Novel;
import com.tr.MNA.Model.Post;
import com.tr.MNA.Repository.NovelRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class NovelService {

    @Autowired
    private NovelRepo novelRepository;

    public Iterable<Novel> findAll() {
        return novelRepository.findAll();
    }

    public Optional<Novel> findById(Long id) {
        return novelRepository.findById(id);
    }

    public Novel save(Novel novel) {
        return novelRepository.save(novel);
    }

    public void deleteById(Long id) {
        novelRepository.deleteById(id);
    }

}