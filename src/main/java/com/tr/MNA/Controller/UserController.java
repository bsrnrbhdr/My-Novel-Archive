package com.tr.MNA.Controller;
import com.tr.MNA.Model.User;
import com.tr.MNA.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/MNA/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private static final Logger log = LoggerFactory.getLogger(PostController.class);

    @GetMapping("/")
    public ResponseEntity<Iterable<User>> getAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);
        if (!user.isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(user.get());
    }


    @PostMapping("/")
    public ResponseEntity create(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @Valid @RequestBody User user) {
        if (!userService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(userService.save(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!userService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
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
