package dev.germantovar.springboot.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "categoriaempleado")

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class CategoriaEmpleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_categoria_emp;
    private String nombre_cat_emp;
    private String estado_cat_emp;
    private String privilegio;
}


