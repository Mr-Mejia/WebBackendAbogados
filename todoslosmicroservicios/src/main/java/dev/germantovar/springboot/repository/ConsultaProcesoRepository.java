package dev.germantovar.springboot.repository;

import dev.germantovar.springboot.entities.Proceso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ConsultaProcesoRepository extends JpaRepository<Proceso, Long> {
}