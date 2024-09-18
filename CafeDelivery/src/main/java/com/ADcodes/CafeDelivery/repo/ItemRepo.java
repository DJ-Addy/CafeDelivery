package com.ADcodes.CafeDelivery.repo;


import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ADcodes.CafeDelivery.model.Items;

public interface ItemRepo extends JpaRepository<Items,Integer> {

    List<Items> findByItemName(String itemName);
    
    List<Items> findByItemCate(String itemCate);

}
