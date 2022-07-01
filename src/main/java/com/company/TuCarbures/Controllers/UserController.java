package com.company.TuCarbures.Controllers;

import com.company.TuCarbures.Classes.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    ServiceUser serviceUser;

    @PostMapping(path = "/")
    @Operation(summary = "Ajoute un utilisateur")
    public User PostUser(@RequestBody User user) {
        return serviceUser.saveUser(user);
    }

    @GetMapping(path = "/connexion/{userName}/{password}")
    @Operation(summary = "connexion de l'utilisateur")
    public Optional<User> connexion(@PathVariable("userName") String userName, @PathVariable("password") String password) {
        Iterable<User> users = serviceUser.findAllUser();
        List<User> result = new ArrayList<>();
        users.forEach(result::add);
        Optional<User> user = null;

        for (int i = 0; i < result.size(); i++) {
            String userNameList = result.get(i).getUserName();
            String passwordList = result.get(i).getPassword();
            String id = result.get(i).getId();

            if (userName.equals(userNameList) && password.equals(passwordList)) {
                user = serviceUser.findUser(id);
            }
        }
        return user;
    }


    @PutMapping("/users/{id}/station/{idStation}")
    @Operation(summary = "changement de station favorite")
    public ResponseEntity<User> updateUserGasStationFavoris(
            @PathVariable(value = "id") String userId, @PathVariable(value = "idStation") String idStation,
            @Valid @RequestBody User userDetails) throws ResourceNotFoundException {
        User user = serviceUser.findUser(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));

        user.setId(userId);
        user.setFavoriteStation(idStation);
        user.setFavoriteFuel(userDetails.getFavoriteFuel());
        serviceUser.updateUserDetails(userDetails, user);

        final User updatedUser = serviceUser.saveUser(user);
        return ResponseEntity.ok(updatedUser);
    }
    @PutMapping("/users/{id}/fuel/{idFuel}")
    @Operation(summary = "changement de carburant favoris ( id ) ")
    public ResponseEntity<User> updateFuelFavoris(
            @PathVariable(value = "id") String userId, @PathVariable(value = "idFuel") String idFuel,
            @Valid @RequestBody User userDetails) throws ResourceNotFoundException {
        User user = serviceUser.findUser(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));

        user.setId(userId);
        user.setFavoriteStation(userDetails.getFavoriteStation());
        user.setFavoriteFuel(idFuel);
        serviceUser.updateUserDetails(userDetails, user);

        final User updatedUser = serviceUser.saveUser(user);
        return ResponseEntity.ok(updatedUser);
    }


}
