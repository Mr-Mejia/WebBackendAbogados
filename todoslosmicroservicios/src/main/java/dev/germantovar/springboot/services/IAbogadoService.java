package dev.germantovar.springboot.services;

import dev.germantovar.springboot.entities.Abogado;

import java.util.List;


public interface IAbogadoService {

    List<Abogado> getAll();
    Abogado getById(Long abogadoID);
    void save(Abogado abogado);
    void remove(Long parseLong);

}


















//void remove(Long id);


//}

