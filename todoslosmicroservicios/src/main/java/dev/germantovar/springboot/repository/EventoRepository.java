package dev.germantovar.springboot.repository;

import dev.germantovar.springboot.entities.Evento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends CrudRepository<Evento, Long> {
}
