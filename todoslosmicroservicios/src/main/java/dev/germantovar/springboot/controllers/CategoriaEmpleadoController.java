package dev.germantovar.springboot.controllers;


import dev.germantovar.springboot.entities.Abogado;
import dev.germantovar.springboot.entities.CategoriaEmpleado;
import dev.germantovar.springboot.entities.CategoriaProceso;
import dev.germantovar.springboot.entities.Customer;
import dev.germantovar.springboot.repository.CategoriaEmpleadoRepository;
import dev.germantovar.springboot.repository.CustomerRepository;
import dev.germantovar.springboot.services.ICategoriaEmpleadoService;
import dev.germantovar.springboot.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoriaEmpleadoController {

    @Autowired
    private ICategoriaEmpleadoService serviceCE;

    @Autowired
    private CategoriaEmpleadoRepository categoriaEmpleadoRepository;

    @GetMapping("api/categoriaempleado")
    public List<CategoriaEmpleado> getAll() {
        return serviceCE.getAll();
    }

    @GetMapping("api/getCE/{id}")
    public CategoriaEmpleado getCategoriaEmpleadoById(@PathVariable String id) {return serviceCE.getById(Long.parseLong(id));}

    @PostMapping("enviarCE")
    public void save(@RequestBody CategoriaEmpleado categoriaEmpleado) {
        serviceCE.save(categoriaEmpleado);
    }


    @DeleteMapping("borrarCE/{id}")
    public void remove(@PathVariable String id) {
        serviceCE.remove(Long.parseLong(id));
    }

    @PutMapping("editarCE/{id}")
    public ResponseEntity<CategoriaEmpleado> update(@PathVariable("id") long id, @RequestBody CategoriaEmpleado categoriaEmpleado) {
        Optional<CategoriaEmpleado> categoriaEmpleadoData = categoriaEmpleadoRepository.findById(id);
        if (categoriaEmpleadoData.isPresent()) {
            CategoriaEmpleado _categoriaEmpleado = categoriaEmpleadoData.get();
            _categoriaEmpleado.setId_categoria_emp(categoriaEmpleado.getId_categoria_emp());
            _categoriaEmpleado.setNombre_cat_emp(categoriaEmpleado.getNombre_cat_emp());
            _categoriaEmpleado.setPrivilegio(categoriaEmpleado.getPrivilegio());
            return new ResponseEntity<>(categoriaEmpleadoRepository.save(_categoriaEmpleado), HttpStatus.ACCEPTED);
        } else {
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
