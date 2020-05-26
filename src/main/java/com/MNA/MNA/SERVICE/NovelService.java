package com.MNA.MNA.SERVICE;

import com.MNA.MNA.DTO.NovelDTO;
import com.MNA.MNA.MODEL.Novel;
import com.MNA.MNA.REPO.NovelRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
@AllArgsConstructor
public class NovelService {

    @Autowired
    private NovelRepo novelRepository;

    public List<Novel> findAll(){
        return novelRepository.findAll();
    }

    public Novel saveNovel(NovelDTO request) {
        Novel novel = new Novel();
        novel.setAuthor(request.getAuthor());
        novel.setNovel_name(request.getNovel_name());
        novel.setYear(request.getYear());
        return novelRepository.save(novel);
    }

    public Novel findById(Long id) {
        return novelRepository.getOne(id);
    }

    public Novel updateNovel(Long id, NovelDTO request) {
        Novel updatedNovel = Optional.of(novelRepository.getOne(id)).map(novel -> {
            novel.setAuthor(request.getAuthor());
            novel.setNovel_name(request.getNovel_name());
            novel.setYear(request.getYear());
            return novel;
        }).get();
        return  novelRepository.save(updatedNovel);
    }

    public void deleteById(Long id) {
        novelRepository.deleteById(id);
    }

}