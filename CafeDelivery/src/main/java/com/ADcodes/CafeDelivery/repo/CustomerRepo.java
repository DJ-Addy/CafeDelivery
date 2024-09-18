package com.ADcodes.CafeDelivery.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ADcodes.CafeDelivery.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {

    Customer findByCustEmail(String email);

}
