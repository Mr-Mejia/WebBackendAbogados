package dev.germantovar.springboot.services;

import dev.germantovar.springboot.entities.Abogado;
import dev.germantovar.springboot.entities.CategoriaEmpleado;


import java.util.List;


public interface ICategoriaEmpleadoService {

    List<CategoriaEmpleado> getAll();
    CategoriaEmpleado getById(Long categoriaEmpleadoID);
    void save(CategoriaEmpleado categoriaempleado);
    void remove(Long parseLong);

}


















//void remove(Long id);


//}

