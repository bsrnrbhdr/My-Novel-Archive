package com.MNA.MNA.SERVICE;

import com.MNA.MNA.DTO.UserDTO;
import com.MNA.MNA.MODEL.User;
import com.MNA.MNA.REPO.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.QueryException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserService{

    @Autowired
    private UserRepository userRepository;


    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public Long getUserEntryCount(){return userRepository.getMax_Id();}

    public List<String> findAllNovel(Long user_id, String status) {
        try {
            return userRepository.findAllNovel(user_id, status);
        } catch (QueryException e) {
            throw new QueryException(e.getMessage());
        }
    }
    public List<String> findAllRead(Long user_id) {
        try {
            return userRepository.findAllRead(user_id);
        } catch (QueryException e) {
            throw new QueryException(e.getMessage());
        }
    }
    public List<String> findAllCurrentlyReading(Long user_id) {
        try {
            return userRepository.findAllCurrentlyReading(user_id);
        } catch (QueryException e) {
            throw new QueryException(e.getMessage());
        }
    }
    public List<String> findAllDropped(Long user_id) {
        try {
            return userRepository.findAllDropped(user_id);
        } catch (QueryException e) {
            throw new QueryException(e.getMessage());
        }
    }

    public User save(UserDTO request) {
        User user = new User();
        try {
            user.setUsername(request.getUsername());
            user.setEmail(request.getEmail());
            user.setPassword(request.getPassword());
            return userRepository.save(user);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public User findById(Long id) {
        return userRepository.getOne(id);
    }

    public User updateUser(Long id, UserDTO request) {
        try {
        User updatedUser = Optional.of(userRepository.getOne(id)).map(user -> {
            user.setUsername(request.getUsername());
            user.setEmail(request.getEmail());
            user.setPassword(request.getPassword());
            return user;
        }).get();
        return  userRepository.save(updatedUser);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public Integer CountRead(Long id){
        try {
            return userRepository.CountRead(id);
        } catch (QueryException e) {
            throw new QueryException(e.getMessage());
        }
    }
    public Integer CountDropped(Long id){
        try {
            return userRepository.CountDropped(id);
        } catch (QueryException e) {
            throw new QueryException(e.getMessage());
        }
    }
    public Integer CountCurrentlyReading(Long id){
        try {
            return userRepository.CountCurrentlyReading(id);
        } catch (QueryException e) {
            throw new QueryException(e.getMessage());
        }
    }
    public Integer NovelCount(Long id){
        try {
            return userRepository.NovelCount(id);
        } catch (QueryException e) {
            throw new QueryException(e.getMessage());
        }
    }

    public User findByUsername(String name) {
        try {
            return userRepository.findByUsername(name);
        } catch (QueryException e) {
            throw new QueryException(e.getMessage());
        }
    }
}