package dev.germantovar.springboot.entities;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
@Entity
@Table(name = "productos")

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private String tipo;
    private String serial;
    private String fecha;
    private String peso;
    private String alto;
    private String ancho;
    private String largo;
    private String precio;
    private String imagen;
    private String direccion;
    private String url;
    private String distribuidor;



}


