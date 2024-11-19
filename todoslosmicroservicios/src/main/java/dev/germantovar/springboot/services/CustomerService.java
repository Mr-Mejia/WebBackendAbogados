package dev.germantovar.springboot.services;

import dev.germantovar.springboot.entities.Customer;
import dev.germantovar.springboot.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    CustomerRepository repository;


    @Override
    public List<Customer> getAll() {
        return (List<Customer>) repository.findAll();
    }

    @Override
    public void save(Customer customer) {
        repository.save(customer);
    }


    @Override
    public void remove(Long id){
        repository.deleteById(id);
    }


}








    //@Override
    //public void remove(Long id){
      //  repository.deleteById(id);
    //}

//}
