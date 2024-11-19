package dev.germantovar.springboot.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "proceso")

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Proceso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_proceso;
    private String estado_actual;
    private Long id_radicado;
    private String fecha_creacion;
    private String fecha_asignacion;
    private Long categoria_proc;
    private Long id_evento;

    @OneToMany(mappedBy = "proceso") //El mapping hace referencia a la tabla proceso

    @JsonManagedReference ("relacionEventoProceso") //Vincula los dos atributos, sin pasar por la BD
    private List<Evento> eventos = new ArrayList<>();

    @ManyToOne //El mapping hace referencia a la tabla proceso
    @JoinColumn(name="id_cliente") //Crea la columna en BD, que a la vez es la llave foranea. Y se borra en la entidad
    @JsonManagedReference ("relacionProcesoCliente") //Vincula los dos atributos, sin pasar por la BD
    private Cliente cliente ;

    @ManyToOne //El mapping hace referencia a la tabla proceso
    @JoinColumn(name="id_abogado") //Crea la columna en BD, que a la vez es la llave foranea. Y se borra en la entidad
    @JsonManagedReference ("relacionProcesoAbogado") //Vincula los dos atributos, sin pasar por la BD
    private Abogado abogado ;


}


