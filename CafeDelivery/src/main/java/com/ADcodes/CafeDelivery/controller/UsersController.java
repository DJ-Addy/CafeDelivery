package com.ADcodes.CafeDelivery.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ADcodes.CafeDelivery.model.Users;
import com.ADcodes.CafeDelivery.repo.UsersRepo;

@RestController
@CrossOrigin("http://localhost:3000")
public class UsersController {
    @Autowired
    private UsersRepo usersRepo;

    // Get all users
    @GetMapping("/users")
    public List<Users> getAllUsers() {
        return usersRepo.findAll();
    }

    // Add a new user
    @PostMapping("/users")
    public Users createUser(@RequestBody Users newUser) {
        return usersRepo.save(newUser);
    }

    // Get a user by ID
    @GetMapping("/users/{id}")
    public Users getUserById(@PathVariable Integer id) {
        return usersRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    // Update a user by ID
    @PutMapping("/users/{id}")
    public Users updateUser(@RequestBody Users updatedUser, @PathVariable Integer id) {
        return usersRepo.findById(id)
        .map(user -> {
            user.setUsername(updatedUser.getUsername());
            user.setPasswordHash(updatedUser.getPasswordHash());
            user.setRole(updatedUser.getRole()); // Set the role
            return usersRepo.save(user);
        })
        .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    // Delete a user by ID
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Integer id) {
        usersRepo.deleteById(id);
        return "User with ID " + id + " deleted";
    }

}
