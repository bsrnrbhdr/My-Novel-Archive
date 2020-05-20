package com.tr.MNA.Controller;

import com.tr.MNA.Model.Novel;
import com.tr.MNA.Service.NovelService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/MNA/novels")
@RestController
public class NovelController {

    @Autowired
    private NovelService novelService;

    private static final Logger log = LoggerFactory.getLogger(NovelController.class);

    @GetMapping("/")
    public ResponseEntity<Iterable<Novel>> getAll() {
        return ResponseEntity.ok(novelService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Novel> findById(@PathVariable Long id) {
        Optional<Novel> novel = novelService.findById(id);
        if (!novel.isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(novel.get());
    }


    @PostMapping("/")
    public ResponseEntity create(@RequestBody Novel novel) {
        return ResponseEntity.ok(novelService.save(novel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Novel> update(@PathVariable Long id, @Valid @RequestBody Novel novel) {
        if (!novelService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(novelService.save(novel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!novelService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        novelService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}