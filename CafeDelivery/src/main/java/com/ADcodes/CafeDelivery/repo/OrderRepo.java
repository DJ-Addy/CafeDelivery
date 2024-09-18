package com.ADcodes.CafeDelivery.repo;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ADcodes.CafeDelivery.model.Customer;
import com.ADcodes.CafeDelivery.model.Orders;

public interface OrderRepo extends JpaRepository<Orders,Integer>{
    
    List<Orders> findByCustomer(Customer customer);

}
