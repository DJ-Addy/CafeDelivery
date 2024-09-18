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

import com.ADcodes.CafeDelivery.model.Roles;
import com.ADcodes.CafeDelivery.repo.RolesRepo;

@RestController
@CrossOrigin("http://localhost:3000")
public class RolesController {

    @Autowired
    private RolesRepo rolesRepo;

    // Create a new role
    @PostMapping("/roles")
    public Roles createRole(@RequestBody Roles role) {
        return rolesRepo.save(role);
    }

    // Get all roles
    @GetMapping("/roles")
    public List<Roles> getAllRoles() {
        return rolesRepo.findAll();
    }

    // Get a role by ID
    @GetMapping("/roles/{id}")
    public Roles getRoleById(@PathVariable Integer id) {
        return rolesRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found with id " + id));
    }

    // Update a role by ID
    @PutMapping("/roles/{id}")
    public Roles updateRole(@RequestBody Roles roleDetails, @PathVariable Integer id) {
        return rolesRepo.findById(id).map(role -> {
            role.setRoleName(roleDetails.getRoleName());
            return rolesRepo.save(role);
        }).orElseThrow(() -> new RuntimeException("Role not found with id " + id));
    }

    // Delete a role by ID
    @DeleteMapping("/roles/{id}")
    public void deleteRole(@PathVariable Integer id) {
        rolesRepo.deleteById(id);
    }

}
