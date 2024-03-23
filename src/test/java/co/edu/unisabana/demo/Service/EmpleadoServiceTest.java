package co.edu.unisabana.demo.Service;

import co.edu.unisabana.demo.Entity.Empleado;
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
    private co.edu.unisabana.demo.Repository.EmpleadoRepository repository;

    @InjectMocks
    private EmpleadoService service;

    @BeforeEach
    void setUp() {
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

        when(repository.save(empleadoParaGuardar)).thenReturn(empleadoParaGuardar);
        Empleado empleadoGuardado = service.guardarEmpleado(empleadoParaGuardar);
        verify(repository, times(1)).save(empleadoParaGuardar);
        assertEquals(empleadoParaGuardar, empleadoGuardado);

    }

    @Test
    void consultarEmpleado() {
        Integer id = 1;
        Empleado empleado = new Empleado();
        empleado.setId(id);
        empleado.setNombre("Carlos");
        empleado.setDireccion("Calle Krlos");
        empleado.setTelefono(123456);
        empleado.setCargo("Cargo Krlosss");

        when(repository.findById(id)).thenReturn(Optional.of(empleado));
        Empleado resultado = service.consultarEmpleado(id);
        verify(repository, times(1)).findById(id);

        assertEquals(empleado, resultado);
    }

    @Test
    void eliminarEmpleado() {
        Integer id = 1;
        Empleado empleado = new Empleado();
        when(repository.findById(id)).thenReturn(Optional.of(empleado));
        boolean resultado = service.eliminarEmpleado(id);
        verify(repository, times(1)).findById(id);
        assertTrue(resultado);
    }

    @Test
    void modificarEmpleado() {
        Integer id = 1;
        Empleado empleado = new Empleado();
        empleado.setId(id);
        empleado.setNombre("Nuevo nombre");
        empleado.setDireccion("Nueva dirección");
        empleado.setTelefono(987654321);
        empleado.setCargo("Nuevo cargo");


        when(repository.findById(id)).thenReturn(Optional.of(new Empleado()));
        when(repository.save(any(Empleado.class))).thenReturn(empleado);


        boolean resultado = service.modificarEmpleado(id, empleado);


        verify(repository, times(1)).findById(id);
        verify(repository, times(1)).save(any(Empleado.class));


        assertTrue(resultado);
    }

}

