package dev.germantovar.springboot.controllers;


import dev.germantovar.springboot.entities.Abogado;
import dev.germantovar.springboot.entities.Customer;
import dev.germantovar.springboot.entities.Proceso;
import dev.germantovar.springboot.repository.CustomerRepository;
import dev.germantovar.springboot.repository.ProcesoRepository;
import dev.germantovar.springboot.services.ICustomerService;
import dev.germantovar.springboot.services.IProcesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProcesoController {

    @Autowired
    private IProcesoService serviceP;

    @Autowired
    private ProcesoRepository procesoRepository;

    @GetMapping("api/proceso")
    public List<Proceso> getAll() {
        return serviceP.getAll();
    }

    @GetMapping("api/getProceso/{id}")
    public Proceso getProcesoById(@PathVariable String id) {return serviceP.getById(Long.parseLong(id));}

    @PostMapping("enviarP")
    public void save(@RequestBody Proceso proceso) {
        serviceP.save(proceso);
    }


    @DeleteMapping("borrarP/{id}")
    public void remove(@PathVariable String id){
        serviceP.remove(Long.parseLong(id));
    }

    @PutMapping("editarP/{id}")
    public ResponseEntity<Proceso> update(@PathVariable("id") long id, @RequestBody Proceso proceso){
        Optional<Proceso> procesoData = procesoRepository.findById(id);
        if (procesoData.isPresent()) {
            Proceso _proceso = procesoData.get();
            _proceso.setId_proceso(proceso.getId_proceso());
            _proceso.setEstado_actual(proceso.getEstado_actual());
            _proceso.setId_radicado(proceso.getId_radicado());
            _proceso.setFecha_creacion(proceso.getFecha_creacion());
            _proceso.setFecha_asignacion(proceso.getFecha_asignacion());
            _proceso.setCategoria_proc(proceso.getCategoria_proc());
            _proceso.setId_evento(proceso.getId_evento());
            return new ResponseEntity<>(procesoRepository.save(_proceso), HttpStatus.ACCEPTED);
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
