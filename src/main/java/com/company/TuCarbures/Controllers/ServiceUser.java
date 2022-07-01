package com.company.TuCarbures.Controllers;

import com.company.TuCarbures.Classes.Fuel;
import com.company.TuCarbures.Classes.User;
import com.company.TuCarbures.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
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

    public void updateUserDetails(@RequestBody @Valid User userDetails, User user) {
        user.setAdress(userDetails.getAdress());
        user.setZipCode(userDetails.getZipCode());
        user.setCity(userDetails.getCity());
        user.setNumberPhone(userDetails.getNumberPhone());
        user.setPassword(userDetails.getPassword());
        user.setEmail(userDetails.getEmail());
        user.setUserName(userDetails.getUserName());
    }
}
