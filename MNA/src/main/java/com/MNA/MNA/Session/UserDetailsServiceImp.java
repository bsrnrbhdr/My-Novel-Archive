package com.MNA.MNA.Session;


import com.MNA.MNA.MODEL.User;
import com.MNA.MNA.REPO.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        UserBuilder builder = null;
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        else {
            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
            builder.roles("USER");
        }
        return builder.build();
    }

//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username);
//        UserBuilder builder = null;
//        if (user != null) {
//            builder = org.springframework.security.core.userdetails.User.withUsername(username);
//            builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
//            builder.roles("USER");
//        } else {
//            throw new UsernameNotFoundException("User not found.");
//        }
//
//        return builder.build();
//    }
//
//    private User findUserbyUsername(String username) {
//        User user= new User();
//        if(username.equalsIgnoreCase("admin")) {
//            user.setUsername(username);
//            user.setPassword("admin123");
//            return user;
//        }
//        return null;
//    }
}