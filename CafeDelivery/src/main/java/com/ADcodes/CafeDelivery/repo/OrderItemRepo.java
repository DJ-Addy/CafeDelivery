package com.ADcodes.CafeDelivery.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ADcodes.CafeDelivery.model.OrderItems;

public interface OrderItemRepo extends JpaRepository<OrderItems,Integer> {

    List<OrderItems> findByOrderOrderId(Integer orderId);
    
    void deleteByOrderOrderId(Integer orderId);

}
