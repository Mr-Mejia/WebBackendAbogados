package dev.germantovar.springboot.services;

import dev.germantovar.springboot.entities.Customer;
import dev.germantovar.springboot.entities.Evento;
import dev.germantovar.springboot.repository.CustomerRepository;
import dev.germantovar.springboot.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService implements IEventoService {

    @Autowired
    EventoRepository repository;


    @Override
    public List<Evento> getAll() {
        return (List<Evento>) repository.findAll();
    }

    @Override
    public Evento getById(Long eventoID) {

        return (Evento) repository.findById(eventoID).get();
    }

    @Override
    public void save(Evento evento) {repository.save(evento);
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
