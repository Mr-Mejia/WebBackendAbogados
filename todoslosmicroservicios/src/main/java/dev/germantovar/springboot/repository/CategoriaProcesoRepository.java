package dev.germantovar.springboot.repository;

import dev.germantovar.springboot.entities.CategoriaProceso;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaProcesoRepository extends CrudRepository<CategoriaProceso, Long> {
}
