package dev.germantovar.springboot.services;

import dev.germantovar.springboot.entities.Customer;

import java.util.List;


public interface ICustomerService {
    List<Customer> getAll();

    void save(Customer customer);

    void remove(Long parseLong);

}


















//void remove(Long id);


//}

