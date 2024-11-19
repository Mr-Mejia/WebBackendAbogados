package dev.germantovar.springboot.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "evento")

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_evento;
    private String anotacion;
    private String fecha_evento;
    private String documento;


    @ManyToOne
    @JsonBackReference ("relacionEventoProceso")

    @JoinColumn(name = "id_proceso")
    private Proceso proceso;

}


