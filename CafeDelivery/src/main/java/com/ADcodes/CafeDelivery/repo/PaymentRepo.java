package com.ADcodes.CafeDelivery.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ADcodes.CafeDelivery.model.Orders;
import com.ADcodes.CafeDelivery.model.Payment;

public interface PaymentRepo extends JpaRepository<Payment,Integer> {

    List<Payment> findByOrder(Orders order); 

}
