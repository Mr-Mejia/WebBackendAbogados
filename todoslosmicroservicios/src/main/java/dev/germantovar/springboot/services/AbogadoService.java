package dev.germantovar.springboot.services;

import dev.germantovar.springboot.entities.Abogado;
import dev.germantovar.springboot.repository.AbogadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbogadoService implements IAbogadoService {

    @Autowired
    AbogadoRepository repository;


    @Override
    public List<Abogado> getAll() {
        return (List<Abogado>) repository.findAll();
    }

    @Override
    public void save(Abogado abogado) {
        repository.save(abogado);
    }

    @Override
    public Abogado getById(Long abogadoID) {

        return (Abogado) repository.findById(abogadoID).get();
    }

    @Override
    public void remove(Long id){
        repository.deleteById(id);
    }




}