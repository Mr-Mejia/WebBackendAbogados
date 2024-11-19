package dev.germantovar.springboot.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente")

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;
    private String nombre_cli;
    private String apellido_cli;
    private String cedula_cli;
    private String telefono_cli;
    private String correo_cli;
    private String direccion_cli;



    @OneToMany(mappedBy = "cliente")
    @JsonBackReference("relacionProcesoCliente")
    private List<Proceso> procesos = new ArrayList<>();

}


