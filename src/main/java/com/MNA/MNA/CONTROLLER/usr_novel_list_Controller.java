package com.MNA.MNA.CONTROLLER;

import com.MNA.MNA.DTO.ListDTO;

import com.MNA.MNA.MODEL.User;
import com.MNA.MNA.MODEL.usr_novel_list;
import com.MNA.MNA.SERVICE.NovelService;
import com.MNA.MNA.SERVICE.UserService;
import com.MNA.MNA.SERVICE.usr_novel_list_service;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/MNA/novel_lists")
@RestController
public class usr_novel_list_Controller {

    @Autowired
    private NovelService novelService;
    @Autowired
    private UserService userService;
    @Autowired
    private usr_novel_list_service usr_novel_list_Service;

    private static final Logger log = LoggerFactory.getLogger(NovelController.class);

    @GetMapping("/all-lists")
    public ResponseEntity<List<usr_novel_list>> getAll() {
        return ResponseEntity.ok(usr_novel_list_Service.findAll());
    }

    @GetMapping("/lists")
    public ResponseEntity<List<usr_novel_list>> getAllToUser(Authentication authentication){
        String name = authentication.getName();
        User user = userService.findByUsername(name);
        return ResponseEntity.ok(usr_novel_list_Service.findAllByUserId(user.getId()));
    }

    @PostMapping("/save")
    public ResponseEntity<usr_novel_list> create(Authentication authentication, @RequestBody ListDTO list)  {
        String name = authentication.getName();
        User user = userService.findByUsername(name);
        return ResponseEntity.ok(usr_novel_list_Service.saveToNovelList(user.getId(),list));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (usr_novel_list_Service.findById(id) == null) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        usr_novel_list_Service.deleteById(id);
        return ResponseEntity.ok().build();
    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<usr_novel_list> update(@PathVariable Long id, @Valid @RequestBody usr_novel_list novel_list) {
//        if (!usr_novel_list_Service.findById(id).isPresent()) {
//            log.error("Id " + id + " is not existed");
//            ResponseEntity.badRequest().build();
//        }
//        return ResponseEntity.ok(usr_novel_list_Service.save(novel_list));
//    }

}