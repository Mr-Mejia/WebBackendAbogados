package dev.germantovar.springboot.services;


import dev.germantovar.springboot.entities.Abogado;
import dev.germantovar.springboot.entities.CategoriaEmpleado;
import dev.germantovar.springboot.repository.CategoriaEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaEmpleadoService implements ICategoriaEmpleadoService {

    @Autowired
    CategoriaEmpleadoRepository repository;


    @Override
    public List<CategoriaEmpleado> getAll() {
        return (List<CategoriaEmpleado>) repository.findAll();
    }
    @Override
    public CategoriaEmpleado getById(Long categoriaEmpleadoID) {

        return (CategoriaEmpleado) repository.findById(categoriaEmpleadoID).get();
    }
    @Override
    public void save(CategoriaEmpleado categoriaempleado) {
        repository.save(categoriaempleado);
    }


    @Override
    public void remove(Long id){
        repository.deleteById(id);
    }


}

