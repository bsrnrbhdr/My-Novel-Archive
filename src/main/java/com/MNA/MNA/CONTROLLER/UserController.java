package com.MNA.MNA.CONTROLLER;
import com.MNA.MNA.DTO.NovelDTO;
import com.MNA.MNA.DTO.UserDTO;
import com.MNA.MNA.MODEL.Novel;
import com.MNA.MNA.MODEL.User;
import com.MNA.MNA.SERVICE.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RequiredArgsConstructor
@RequestMapping("/MNA/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private static final Logger log = LoggerFactory.getLogger(NovelController.class);

    @GetMapping("/list")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = userService.findById(id);
        if (user== null) {
            log.error("Id " + id + " is not existed");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(user);
    }


    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody UserDTO user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @Valid @RequestBody UserDTO user) {
        if (userService.findById(id)==null) {
            log.error("Id " + id + " is not existed");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(userService.updateUser(id,user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        if (userService.findById(id)==null) {
            log.error("Id " + id + " is not existed");
            return ResponseEntity.badRequest().build();
        }
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list/{user_id}/{status}")
    public ResponseEntity<List<String>> findAllNovel(@PathVariable Long user_id,@PathVariable String status) {
        List<String> novel_l = userService.findAllNovel(user_id,status);
        if (novel_l == null) {
            return new ResponseEntity<>((List<String>) null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(novel_l, HttpStatus.OK);
    }

}