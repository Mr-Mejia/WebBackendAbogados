package dev.germantovar.springboot.controllers;


import dev.germantovar.springboot.entities.Abogado;
import dev.germantovar.springboot.entities.Cliente;
import dev.germantovar.springboot.repository.ClienteRepository;
import dev.germantovar.springboot.services.IClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {

    @Autowired
    private IClienteService serviceC;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("api/cliente")
    public List<Cliente> getAll() {
        return serviceC.getAll();
    }

    @GetMapping("api/getCliente/{id}")
    public Cliente getAbogadoById(@PathVariable String id) {return serviceC.getById(Long.parseLong(id));}

    @PostMapping("enviarC")
    public void save(@RequestBody Cliente cliente) {
        serviceC.save(cliente);
    }


    @DeleteMapping("borrarC/{id}")
    public void remove(@PathVariable String id){
        serviceC.remove(Long.parseLong(id));
    }

    @PutMapping("editarC/{id}")
    public ResponseEntity<Cliente> update(@PathVariable("id") long id, @RequestBody Cliente cliente){
        Optional<Cliente> clienteData = clienteRepository.findById(id);
        if (clienteData.isPresent()) {
            Cliente _cliente = clienteData.get();
            _cliente.setId_cliente(cliente.getId_cliente());
            _cliente.setNombre_cli(cliente.getNombre_cli());
            _cliente.setApellido_cli(cliente.getApellido_cli());
            _cliente.setCedula_cli(cliente.getCedula_cli());
            _cliente.setTelefono_cli(cliente.getTelefono_cli());
            _cliente.setCorreo_cli(cliente.getCorreo_cli());
            _cliente.setDireccion_cli(cliente.getDireccion_cli());
            return new ResponseEntity<>(clienteRepository.save(_cliente), HttpStatus.ACCEPTED);
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
