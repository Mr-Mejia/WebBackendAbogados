package dev.germantovar.springboot.services;

import dev.germantovar.springboot.entities.Abogado;
import dev.germantovar.springboot.entities.Cliente;
import dev.germantovar.springboot.entities.Customer;
import dev.germantovar.springboot.repository.ClienteRepository;
import dev.germantovar.springboot.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    ClienteRepository repository;

    @Override
    public List<Cliente> getAll() {
        return (List<Cliente>) repository.findAll();
    }

    @Override
    public Cliente getById(Long clienteID) {
        return (Cliente) repository.findById(clienteID).get();
    }

    @Override
    public void save(Cliente cliente) {
        repository.save(cliente);
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
