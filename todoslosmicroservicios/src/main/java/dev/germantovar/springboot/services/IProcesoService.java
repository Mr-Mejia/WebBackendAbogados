package dev.germantovar.springboot.services;


import dev.germantovar.springboot.entities.Abogado;
import dev.germantovar.springboot.entities.Proceso;

import java.util.List;


public interface IProcesoService {
    List<Proceso> getAll();

    Proceso getById(Long procesoID);

    void save(Proceso proceso);

    void remove(Long parseLong);

}


















//void remove(Long id);


//}

