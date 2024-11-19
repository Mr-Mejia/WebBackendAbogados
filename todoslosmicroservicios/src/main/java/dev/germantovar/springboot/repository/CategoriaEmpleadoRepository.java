package dev.germantovar.springboot.repository;

import dev.germantovar.springboot.entities.CategoriaEmpleado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaEmpleadoRepository extends CrudRepository<CategoriaEmpleado, Long> {
}
