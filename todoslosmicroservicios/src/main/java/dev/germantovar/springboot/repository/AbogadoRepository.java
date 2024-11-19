package dev.germantovar.springboot.repository;

import dev.germantovar.springboot.entities.Abogado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbogadoRepository extends CrudRepository<Abogado, Long> {
}
