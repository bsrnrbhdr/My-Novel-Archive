package com.tr.MNA.Service;

import com.tr.MNA.Model.User;
import com.tr.MNA.Model.usr_novel_list;
import com.tr.MNA.Repository.UserRepository;
import io.lettuce.core.dynamic.annotation.Param;
import lombok.AllArgsConstructor;
import org.hibernate.QueryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User save(User user) {
        return userRepository.save(user);
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

}