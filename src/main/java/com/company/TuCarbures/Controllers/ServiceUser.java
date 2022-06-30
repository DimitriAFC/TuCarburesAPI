package com.company.TuCarbures.Controllers;

import com.company.TuCarbures.Classes.Fuel;
import com.company.TuCarbures.Classes.User;
import com.company.TuCarbures.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceUser {

    @Autowired
    UserRepository userRepository;

    public Optional<User> findUser(String id){
        return userRepository.findById(id);
    }
    public User saveUser(User user){
        return userRepository.save(user);
    }
    public Iterable<User> findAllUser(){
        return userRepository.findAll();
    }
}
