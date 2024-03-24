package co.edu.unisabana.demo.service;

import co.edu.unisabana.demo.entity.Rol;
import co.edu.unisabana.demo.repository.RolesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class RolesServiceTest {

    @Mock
    private RolesRepository repository;

    @InjectMocks
    private RolesService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void DadoGuardarRol_CuandoRol_EntoncesGuardarElRol() {
        Rol mRol = new Rol();
        when(repository.save(any(Rol.class))).thenReturn(mRol);

        Rol resultado = service.guardarRoles(new Rol());
        assertNotNull(resultado);
        assertEquals(mRol, resultado);

        verify(repository, times(1)).save(any(Rol.class));
    }

    @Test
    void DadoRolesExistentes_CuandoConsultarRolesActuales_EntoncesMostrarTodosLosRoles() {
        List<Rol> mockRolesList = Arrays.asList(new Rol(), new Rol());
        when(repository.findAll()).thenReturn(mockRolesList);

        List<Rol> resultado = service.consultarRoles();
        assertNotNull(resultado);
        assertEquals(mockRolesList.size(), resultado.size());

        verify(repository, times(1)).findAll();
    }

    @Test
    void DadoRol_CuandoConsultarNombreRol_MostrarRol() {
        String nombre = "Rol 1";
        Rol mRol = new Rol();
        when(repository.findById(nombre)).thenReturn(Optional.of(mRol));

        Rol resultado = service.consultarRole(nombre);
        assertNotNull(resultado);
        assertEquals(mRol, resultado);

        verify(repository, times(1)).findById(nombre);
    }

    @Test
    void DadoRolExistente_CuandoRolNoNecesario_EntoncesEliminarRolExistente() {
        String nombre = "Rol 1";
        when(repository.findById(nombre)).thenReturn(Optional.of(new Rol()));

        boolean resultado = service.eliminarRole(nombre);
        assertTrue(resultado);

        verify(repository, times(1)).findById(nombre);
        verify(repository, times(1)).deleteById(nombre);
    }

    @Test
    void DadoRolExistente_CuandoRolDesactualizado_EntoncesModificarRolExistente() {
        String nombre = "Rol 1";
        Rol rolExistente = new Rol();
        Rol rolActualizado = new Rol();
        when(repository.findById(nombre)).thenReturn(Optional.of(rolExistente));

        boolean result = service.modificarRole(nombre, rolActualizado);
        assertTrue(result);

        verify(repository, times(1)).findById(nombre);
        verify(repository, times(1)).save((rolExistente));
    }
}