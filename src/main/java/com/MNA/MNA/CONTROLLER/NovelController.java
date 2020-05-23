package com.MNA.MNA.CONTROLLER;

import com.MNA.MNA.DTO.NovelDTO;
import com.MNA.MNA.MODEL.Novel;
import com.MNA.MNA.SERVICE.NovelService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RequiredArgsConstructor
@RequestMapping("/MNA/novels")
@RestController
public class NovelController {

    @Autowired
    private NovelService novelService;

    private static final Logger log = LoggerFactory.getLogger(NovelController.class);

    @GetMapping("/list")
    public ResponseEntity<List<Novel>> getAllNovels() {
        return ResponseEntity.ok(novelService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Novel> findById(@PathVariable Long id) {
        Novel novel = novelService.findById(id);
        if (novel== null) {
            log.error("Id " + id + " is not existed");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(novel);
    }


    @PostMapping("/save")
    public ResponseEntity<Novel> saveNovel(@RequestBody NovelDTO novel) {
        return ResponseEntity.ok(novelService.saveNovel(novel));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Novel> updateNovel(@PathVariable Long id, @Valid @RequestBody NovelDTO novel) {
        if (novelService.findById(id)==null) {
            log.error("Id " + id + " is not existed");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(novelService.updateNovel(id,novel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Novel> deleteNovel(@PathVariable Long id) {
        if (novelService.findById(id)==null) {
            log.error("Id " + id + " is not existed");
             return ResponseEntity.badRequest().build();
        }
        novelService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}