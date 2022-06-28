package com.company.TuCarbures.Controllers;

import com.company.TuCarbures.Classes.User;
import com.company.TuCarbures.Repositories.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping(path = "/user/add")
    @Operation(summary = "Ajoute un utilisateur")
    public String PostUser(@RequestBody User user){
        userRepository.save(user);
        return "Utilisateur sauvegardé ";
    }
}
