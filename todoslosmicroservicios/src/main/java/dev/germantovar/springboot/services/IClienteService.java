package dev.germantovar.springboot.services;

import dev.germantovar.springboot.entities.Abogado;
import dev.germantovar.springboot.entities.Cliente;

import java.util.List;


public interface IClienteService {
    List<Cliente> getAll();

    Cliente getById(Long clienteID);

    void save(Cliente cliente);

    void remove(Long parseLong);

}


















//void remove(Long id);


//}

