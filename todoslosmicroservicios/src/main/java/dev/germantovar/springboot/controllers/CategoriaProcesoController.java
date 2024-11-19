package dev.germantovar.springboot.controllers;


import dev.germantovar.springboot.entities.Abogado;
import dev.germantovar.springboot.entities.CategoriaProceso;
import dev.germantovar.springboot.entities.Customer;
import dev.germantovar.springboot.repository.CategoriaProcesoRepository;
import dev.germantovar.springboot.repository.CustomerRepository;
import dev.germantovar.springboot.services.ICategoriaProcesoService;
import dev.germantovar.springboot.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoriaProcesoController {

    @Autowired
    private ICategoriaProcesoService serviceCP;

    @Autowired
    private CategoriaProcesoRepository categoriaProcesoRepository;

    @GetMapping("api/categoriaprocesos")
    public List<CategoriaProceso> getAll() {
        return serviceCP.getAll();
    }

    @GetMapping("api/getCP/{id}")
    public CategoriaProceso getCategoriaProcesoById(@PathVariable String id) {return serviceCP.getById(Long.parseLong(id));}

    @PostMapping("enviarCP")
    public void save(@RequestBody CategoriaProceso categoriaproceso) {
        serviceCP.save(categoriaproceso);
    }

    @DeleteMapping("borrarCP/{id}")
    public void remove(@PathVariable String id){
        serviceCP.remove(Long.parseLong(id));
    }

    @PutMapping("editarCP/{id}")
    public ResponseEntity<CategoriaProceso> update(@PathVariable("id") long id, @RequestBody CategoriaProceso categoriaProceso){
        Optional<CategoriaProceso> categoriaProcesoData = categoriaProcesoRepository.findById(id);
        if (categoriaProcesoData.isPresent()) {
            CategoriaProceso _categoriaProceso = categoriaProcesoData.get();
            _categoriaProceso.setCategoria_proc(categoriaProceso.getCategoria_proc());
            _categoriaProceso.setDescripcion(categoriaProceso.getDescripcion());
            _categoriaProceso.setEstado_cat_pro(categoriaProceso.getEstado_cat_pro());
            return new ResponseEntity<>(categoriaProcesoRepository.save(_categoriaProceso), HttpStatus.ACCEPTED);
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
