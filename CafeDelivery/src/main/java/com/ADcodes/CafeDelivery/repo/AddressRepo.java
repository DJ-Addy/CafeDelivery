package com.ADcodes.CafeDelivery.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ADcodes.CafeDelivery.model.Address;

public interface AddressRepo extends JpaRepository<Address,Integer>{

}
