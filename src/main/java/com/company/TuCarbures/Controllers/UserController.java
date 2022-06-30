package com.company.TuCarbures.Controllers;

import com.company.TuCarbures.Classes.*;
import com.company.TuCarbures.Repositories.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/User")
@CrossOrigin(origins = "*")
@Slf4j
@Tag(name = "Utilisateur", description = "gestion des utilisateurs")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping(path = "/")
    @Operation(summary = "Ajoute un utilisateur")
    public String PostUser(@RequestBody User user) {
        userRepository.save(user);
        return "Utilisateur sauvegardé ";
    }

    @GetMapping(path = "/connexion/{userName}/{password}")
    @Operation(summary = "connexion de l'utilisateur")
    public Optional<User> connexion(@PathVariable("userName") String userName, @PathVariable("password") String password) {
        Iterable<User> users = userRepository.findAll();
        List<User> result = new ArrayList<>();
        users.forEach(result::add);
        Optional<User> user = null;

        for (int i = 0; i < result.size(); i++) {
            String userNameList = result.get(i).userName;
            String passwordList = result.get(i).password;
            String id = result.get(i).id;

            if (userName.equals(userNameList) && password.equals(passwordList)) {
                user = userRepository.findById(id);
            }
        }
        return user;
    }
}
