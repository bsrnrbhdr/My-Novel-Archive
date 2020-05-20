package com.tr.MNA.Controller;

import com.tr.MNA.Exception.ResourceNotFoundException;
import com.tr.MNA.Model.User;
import com.tr.MNA.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserRepo userRepo;
    //get users
    @GetMapping("users")
    public List<User> getAllUsers(){
        return this.userRepo.findAll();
    }
    //get user by id
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException{
        User user = userRepo.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User not found "));
        return ResponseEntity.ok().body(user);
    }
    //save user
    @PostMapping("users")
    public User createUser(@RequestBody User user){
        return this.userRepo.save(user);
    }
    //update user
    @PutMapping("users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable( value ="id") Long userId, @Valid @RequestBody User userDetails) throws ResourceNotFoundException {
        User user = userRepo.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User not found "));
        user.setEmail(userDetails.getEmail());
        user.setSurname(userDetails.getSurname());
        user.setPassword(userDetails.getPassword());
        user.setFirstName(userDetails.getFirstName());
        return ResponseEntity.ok(this.userRepo.save(user));
    }
    //delete user
    @DeleteMapping("user/{id]")
    public Map<String,Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
        User user = userRepo.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User not found "));
        this.userRepo.delete(user);
        Map<String,Boolean> response =new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }
}
