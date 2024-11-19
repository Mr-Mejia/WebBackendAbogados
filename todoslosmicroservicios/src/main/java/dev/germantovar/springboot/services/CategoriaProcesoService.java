package dev.germantovar.springboot.services;


import dev.germantovar.springboot.entities.Abogado;
import dev.germantovar.springboot.entities.CategoriaEmpleado;
import dev.germantovar.springboot.entities.CategoriaProceso;
import dev.germantovar.springboot.repository.CategoriaProcesoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaProcesoService implements ICategoriaProcesoService {

    @Autowired
    CategoriaProcesoRepository repository;


    @Override
    public List<CategoriaProceso> getAll() {
        return (List<CategoriaProceso>) repository.findAll();
    }

    @Override
    public CategoriaProceso getById(Long categoriaProcesoID) {

        return (CategoriaProceso) repository.findById(categoriaProcesoID).get();
    }

    @Override
    public void save(CategoriaProceso categoriaproceso) {
        repository.save(categoriaproceso);
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
