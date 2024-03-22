package co.edu.unisabana.demo.Service;

import co.edu.unisabana.demo.entity.Empleado;
import co.edu.unisabana.demo.service.EmpleadoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmpleadoServiceTest {

    @Mock
    private co.edu.unisabana.demo.repository.EmpleadoRepository repository;

    @InjectMocks
    private EmpleadoService service;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void guardarEmpleado() {
        Empleado empleadoParaGuardar = new Empleado();
        empleadoParaGuardar.setId(1);
        empleadoParaGuardar.setNombre("Carlos");
        empleadoParaGuardar.setDireccion("Calle Krlos");
        empleadoParaGuardar.setTelefono(123456);
        empleadoParaGuardar.setCargo("Cargo Krlosss");

        //Se define el comportamiento esperado del repo al guardar a Krlos
        when(repository.save(empleadoParaGuardar)).thenReturn(empleadoParaGuardar);

        //Se llama al método del servicio
        Empleado empleadoGuardado = service.guardarEmpleado(empleadoParaGuardar);

        //Verificar que se llama al método save del repo con el Krlos correcto
        verify(repository, times(1)).save(empleadoParaGuardar);

        //Verificar que el Krlos que se devolvió es el propio Krlos
        assertEquals(empleadoParaGuardar, empleadoGuardado);

    }

    @Test
    void consultarEmpleado(){
        Integer id = 1;
        Empleado empleado = new Empleado();
        empleado.setId(id);
        empleado.setNombre("Carlos");
        empleado.setDireccion("Calle Krlos");
        empleado.setTelefono(123456);
        empleado.setCargo("Cargo Krlosss");

        //Mockear el comportamiento del repo para la prueba
        when(repository.findById(id)).thenReturn(Optional.of(empleado));

        //Invocar al método de la clase bajo prueba
        Empleado resultado = service.consultarEmpleado(id);

        //Verificar que el método findById fue llamado con el ID correcto
        verify(repository, times(1)).findById(id);

        //Verificar que el resultado retornado es el mismo del empleado esperado (1)
        assertEquals(empleado, resultado);
    }

    @Test
    void eliminarEmpleado(){
        Integer id = 1;
        Empleado empleado = new Empleado();
        when(repository.findById(id)).thenReturn(Optional.of(empleado));

        //Invocar al método de la clase bajo prueba
        boolean resultado = service.eliminarEmpleado(id);

        //Verificar que el método findbyId fue llamado con el Id correcto
        verify(repository, times(1)).findById(id);

        //Verificar que el ID retornado es el del empleado que se espera
        assertTrue(resultado);
    }

    @Test
    void modificarEmpleado(){

    }
}
