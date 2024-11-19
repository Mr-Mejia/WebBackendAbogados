package dev.germantovar.springboot.controllers;


import dev.germantovar.springboot.entities.Abogado;
import dev.germantovar.springboot.repository.AbogadoRepository;
import dev.germantovar.springboot.services.IAbogadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AbogadoController {

    @Autowired
    private IAbogadoService servicioA;

    @Autowired
    private AbogadoRepository abogadoRepository;

    @GetMapping("api/abogado")
    public List<Abogado> getAll() {
        return servicioA.getAll();
    }

    @GetMapping("api/getAbogado/{id}")
    public Abogado getAbogadoById(@PathVariable String id) {return servicioA.getById(Long.parseLong(id));}

    @PostMapping("enviarA")
    public void save(@RequestBody Abogado abogado) {
        servicioA.save(abogado);
    }


    @DeleteMapping("borrarA/{id}")
    public void remove(@PathVariable String id){servicioA.remove(Long.parseLong(id));
    }


    @PutMapping("editarA/{id}")
    public ResponseEntity<Abogado> update(@PathVariable("id") long id, @RequestBody Abogado abogado){
        Optional<Abogado> abogadoData = abogadoRepository.findById(id);
        if (abogadoData.isPresent()) {
            Abogado _abogado = abogadoData.get();
            _abogado.setNombre_abo(abogado.getNombre_abo());
            _abogado.setApellido_abo(abogado.getApellido_abo());
            _abogado.setCedula_abo(abogado.getCedula_abo());
            _abogado.setEstado_abo(abogado.getEstado_abo());
            _abogado.setFecha_ingreso(abogado.getFecha_ingreso());
            _abogado.setFecha_retiro(abogado.getFecha_retiro());
            _abogado.setId_categoria_emp(abogado.getId_categoria_emp());
            return new ResponseEntity<>(abogadoRepository.save(_abogado), HttpStatus.ACCEPTED);
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
