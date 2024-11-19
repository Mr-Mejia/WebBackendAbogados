package dev.germantovar.springboot.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "abogado")

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Abogado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_abogado;
    private String cedula_abo;
    private String nombre_abo;
    private String apellido_abo;
    private Long id_categoria_emp;
    private String estado_abo;
    private String fecha_ingreso;
    private String fecha_retiro;

    @OneToMany(mappedBy = "abogado")
    @JsonBackReference("relacionProcesoAbogado")
    private List<Proceso> procesos = new ArrayList<>();
}


