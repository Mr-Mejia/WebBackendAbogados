package dev.germantovar.springboot.repository;

import dev.germantovar.springboot.entities.Proceso;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcesoRepository extends CrudRepository<Proceso, Long> {
}


