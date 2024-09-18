package com.ADcodes.CafeDelivery.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ADcodes.CafeDelivery.model.Users;

public interface UsersRepo extends JpaRepository<Users,Integer> {

    Users findByUsername(String username);
}
