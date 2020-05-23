package com.MNA.MNA.CONTROLLER;

import com.MNA.MNA.DTO.ListDTO;
import com.MNA.MNA.DTO.NovelDTO;
import com.MNA.MNA.MODEL.usr_novel_list;
import com.MNA.MNA.SERVICE.usr_novel_list_service;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/MNA/novel_lists")
@RestController
public class usr_novel_list_Controller {

    @Autowired
    private usr_novel_list_service usr_novel_list_Service;

    private static final Logger log = LoggerFactory.getLogger(NovelController.class);

    @GetMapping("/all-lists")
    public ResponseEntity<List<usr_novel_list>> getAll() {
        return ResponseEntity.ok(usr_novel_list_Service.findAll());
    }

    @PostMapping(value = "/add")
    public usr_novel_list addDeveloper(@RequestBody ListDTO request) {
        return usr_novel_list_Service.SaveToList(request);
    }


//    @GetMapping("/{id}")
//    public ResponseEntity<usr_novel_list> findById(@PathVariable Long id) {
//        Optional<usr_novel_list> novel_list = usr_novel_list_Service.findById(id);
//        if (!novel_list.isPresent()) {
//            log.error("Id " + id + " is not existed");
//            ResponseEntity.badRequest().build();
//        }
//        return ResponseEntity.ok(novel_list.get());
//    }


//    @PostMapping("/save/{user_id}/{novel_id}")
//    public ResponseEntity<usr_novel_list> create(@PathVariable Long user_id,@PathVariable Long novel_id,@RequestBody ListDTO list)  {
//        return ResponseEntity.ok(usr_novel_list_Service.saveNovel(user_id,novel_id));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<usr_novel_list> update(@PathVariable Long id, @Valid @RequestBody usr_novel_list novel_list) {
//        if (!usr_novel_list_Service.findById(id).isPresent()) {
//            log.error("Id " + id + " is not existed");
//            ResponseEntity.badRequest().build();
//        }
//        return ResponseEntity.ok(usr_novel_list_Service.save(novel_list));
//    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity delete(@PathVariable Long id) {
//        if (!usr_novel_list_Service.findById(id).isPresent()) {
//            log.error("Id " + id + " is not existed");
//            ResponseEntity.badRequest().build();
//        }
//        usr_novel_list_Service.deleteById(id);
//        return ResponseEntity.ok().build();
//    }
}