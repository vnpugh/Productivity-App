package com.example.todoapp.Service;


import com.example.todoapp.Models.User;
import com.example.todoapp.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public User getCurrentUser() {
        Optional<User> user = userRepository.findById(1L);
       if (user.isPresent()) {
           return user.get();
       } else {
           return null; //can also throw an exception here
       }
    }





}
