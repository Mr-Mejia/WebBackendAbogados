package dev.germantovar.springboot.controllers;


import dev.germantovar.springboot.entities.Abogado;
import dev.germantovar.springboot.entities.Evento;
import dev.germantovar.springboot.entities.Evento;
import dev.germantovar.springboot.repository.EventoRepository;
import dev.germantovar.springboot.services.IEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EventoController {

    @Autowired
    private IEventoService serviceE;

    @Autowired
    private EventoRepository eventoRepository;

    @GetMapping("api/evento")
    public List<Evento> getAll() {
        return serviceE.getAll();
    }

    @GetMapping("api/getEvento/{id}")
    public Evento getEventoById(@PathVariable String id) {return serviceE.getById(Long.parseLong(id));}

    @GetMapping("api/getEventoByIdProceso/{id}")
    public Evento getEventosByIdProceso(@PathVariable String id) {return serviceE.getById(Long.parseLong(id));}

    @PostMapping("enviarE")
    public void save(@RequestBody Evento evento) {
        serviceE.save(evento);
    }


    @DeleteMapping("borrarE/{id}")
    public void remove(@PathVariable String id){
        serviceE.remove(Long.parseLong(id));
    }

    @PutMapping("editarE/{id}")
    public ResponseEntity<Evento> update(@PathVariable("id") long id, @RequestBody Evento evento){
        Optional<Evento> eventoData = eventoRepository.findById(id);
        if (eventoData.isPresent()) {
            Evento _evento = eventoData.get();
            _evento.setId_evento(evento.getId_evento());
            //
            _evento.setAnotacion(evento.getAnotacion());
            _evento.setFecha_evento(evento.getFecha_evento());
            _evento.setDocumento(evento.getDocumento());
            return new ResponseEntity<>(eventoRepository.save(_evento), HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>(HttpStatus.FOUND);
        }
    }

}






















    //@PutMapping("/recepcion/{id}")
    //public ResponseEntity<Customer> updateTutorial(@PathVariable("id") long id, @RequestBody Customer customer) {
//  Optional<Customer> customerData = customerRepository.findById(id);
    //      if (customerData.isPresent()) {
//      Customer _customer = customerData.get();
////          _customer.setNombre(customer.getNombre());
//        _customer.setDescripcion(customer.getDescripcion());
//          _customer.setTipo(customer.getTipo());
//          _customer.setSerial(customer.getSerial());
//          _customer.setFecha(customer.getFecha());
//          _customer.setPeso(customer.getPeso());
//          _customer.setAlto(customer.getAlto());
//          _customer.setAncho(customer.getAncho());
//          _customer.setLargo(customer.getLargo());
//          _customer.setPrecio(customer.getPrecio());
//          _customer.setImagen(customer.getImagen());

//          return new ResponseEntity<>(customerRepository.save(_customer), HttpStatus.OK);
//      } else {
//  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        //      }
//}
