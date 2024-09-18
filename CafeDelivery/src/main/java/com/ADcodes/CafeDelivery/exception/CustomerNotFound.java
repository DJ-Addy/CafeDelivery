package com.ADcodes.CafeDelivery.exception;

public class CustomerNotFound extends RuntimeException {
    public CustomerNotFound(Integer id){
        super("Could not found the user with id "+ id);
    }

}
