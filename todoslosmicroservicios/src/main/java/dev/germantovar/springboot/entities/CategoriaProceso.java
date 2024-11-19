package dev.germantovar.springboot.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "categoriaproceso")

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class CategoriaProceso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoria_proc;
    private String descripcion;
    private String estado_cat_pro;
}


