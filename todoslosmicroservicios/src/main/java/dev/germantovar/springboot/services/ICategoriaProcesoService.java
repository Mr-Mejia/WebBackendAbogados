package dev.germantovar.springboot.services;

import dev.germantovar.springboot.entities.Abogado;
import dev.germantovar.springboot.entities.CategoriaProceso;
import dev.germantovar.springboot.entities.Customer;

import java.util.List;


public interface ICategoriaProcesoService {
    List<CategoriaProceso> getAll();
    CategoriaProceso getById(Long categoriaProcesoID);
    void save(CategoriaProceso categoriaProceso);

    void remove(Long parseLong);

}

//void remove(Long id);


//}

