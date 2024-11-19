package dev.germantovar.springboot.services;
import dev.germantovar.springboot.entities.Customer;
import dev.germantovar.springboot.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
//import static javax.print.attribute.TextSyntax.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    // Mockeamos el repositorio
    @Mock
    private CustomerRepository customerRepository;

    // Injectamos el mock en el servicio
    @InjectMocks
    private CustomerService customerService;

    // Inicializamos los mocks antes de cada prueba
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Prueba para el método getAll
    @Test
    void testGetAllCustomers() {
        // Creamos un par de objetos Customer para simular la respuesta del repositorio
        Customer customer1 = new Customer();
        customer1.setId(1L);
        customer1.setNombre("Producto 1");

        Customer customer2 = new Customer();
        customer2.setId(2L);
        customer2.setNombre("Producto 2");

        // Simulamos que el repositorio retorna una lista de clientes
        when(customerRepository.findAll()).thenReturn(Arrays.asList(customer1, customer2));

        // Llamamos al método getAll del servicio
        List<Customer> customers = customerService.getAll();

        // Verificamos que el tamaño de la lista sea el esperado
        assertEquals(2, customers.size());
        assertEquals("Producto 1", customers.get(0).getNombre());
        assertEquals("Producto 2", customers.get(1).getNombre());

        // Verificamos que se haya invocado al método findAll del repositorio
        verify(customerRepository, times(1)).findAll();
    }

    // Prueba para el método save
    @Test
    void testSaveCustomer() {
        // Creamos un nuevo Customer
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setNombre("Producto Nuevo");

        // Simulamos que el repositorio guarda el objeto sin errores
        when(customerRepository.save(customer)).thenReturn(customer);

        // Llamamos al método save del servicio
        customerService.save(customer);

        // Verificamos que se haya invocado al método save del repositorio
        verify(customerRepository, times(1)).save(customer);
    }
}