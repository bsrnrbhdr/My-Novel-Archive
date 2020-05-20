package com.tr.MNA.Controller;
import com.tr.MNA.Model.usr_novel_list;

import com.tr.MNA.Service.usr_novel_list_service;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/MNA/novel_lists")
@RestController
public class usr_novel_list_Controller {

    @Autowired
    private usr_novel_list_service usr_novel_list_Service;

    private static final Logger log = LoggerFactory.getLogger(NovelController.class);

    @GetMapping("/")
    public ResponseEntity<Iterable<usr_novel_list>> getAll() {
        return ResponseEntity.ok(usr_novel_list_Service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<usr_novel_list> findById(@PathVariable Long id) {
        Optional<usr_novel_list> novel_list = usr_novel_list_Service.findById(id);
        if (!novel_list.isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(novel_list.get());
    }


    @PostMapping("/")
    public ResponseEntity create(@RequestBody usr_novel_list novel_list) {
        return ResponseEntity.ok(usr_novel_list_Service.save(novel_list));
    }

    @PutMapping("/{id}")
    public ResponseEntity<usr_novel_list> update(@PathVariable Long id, @Valid @RequestBody usr_novel_list novel_list) {
        if (!usr_novel_list_Service.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(usr_novel_list_Service.save(novel_list));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!usr_novel_list_Service.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        usr_novel_list_Service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}