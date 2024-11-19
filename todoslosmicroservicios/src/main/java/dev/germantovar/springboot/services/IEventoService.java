package dev.germantovar.springboot.services;


import dev.germantovar.springboot.entities.Abogado;
import dev.germantovar.springboot.entities.Evento;

import java.util.List;


public interface IEventoService {
    List<Evento> getAll();

    Evento getById(Long eventoID);

    void save(Evento evento);

    void remove(Long parseLong);


}


















//void remove(Long id);


//}

