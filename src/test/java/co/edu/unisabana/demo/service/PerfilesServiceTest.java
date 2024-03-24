package co.edu.unisabana.demo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import co.edu.unisabana.demo.Entity.Perfil;
import co.edu.unisabana.demo.Repository.PerfilesRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class PerfilesServiceTest {

    private PerfilesService perfilesService;

    @Mock
    private PerfilesRepository repository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        perfilesService = new PerfilesService(repository);
    }

    @Test
    public void dadoPerfil_cuandoId1_entoncesMostrarPerfilEmpleado1() {
        Perfil perfil = new Perfil();
        perfil.setEmpId(1);
        perfil.setCertificaciones("Certificado en Probar Mocos (En software)");
        perfil.setExperencias("Desarrollador Junior");
        perfil.setHabilidades("Trabajo bajo presión");

        when(repository.save(any(Perfil.class))).thenReturn(perfil);

        Perfil result = perfilesService.guardarPerfiles(perfil);

        assertNotNull(result);
        assertEquals(perfil.getEmpId(), result.getEmpId());
        assertEquals(perfil.getCertificaciones(), result.getCertificaciones());
        assertEquals(perfil.getExperencias(), result.getExperencias());
        assertEquals(perfil.getHabilidades(), result.getHabilidades());
    }

    @Test
    public void dadoConsultaPerfil_cuandoIdEmpleado_EntoncesConsultarPerfilesGuardados() {
        Perfil perfil = new Perfil();
        perfil.setEmpId(1);
        perfil.setCertificaciones("Certificado en Probar Mocos (En software)");
        perfil.setExperencias("Desarrollador Junior");
        perfil.setHabilidades("Trabajo bajo presión");

        when(repository.findById(1)).thenReturn(Optional.of(perfil));

        Perfil result = perfilesService.consultarPerfil(1);

        assertNotNull(result);
        assertEquals(perfil.getEmpId(), result.getEmpId());
        assertEquals(perfil.getCertificaciones(), result.getCertificaciones());
        assertEquals(perfil.getExperencias(), result.getExperencias());
        assertEquals(perfil.getHabilidades(), result.getHabilidades());
    }

    @Test
    public void DadoEliminarPerfil_CuandoIdEmpleado1_EntoncesELiminarPerfil() {

        when(repository.findById(1)).thenReturn(Optional.of(new Perfil()));

        boolean result = perfilesService.eliminarPerfil(1);

        assertTrue(result);
        verify(repository, times(1)).deleteById(1);
    }

    @Test
    public void DadoModificarPerfil_CuandoIdEmpleado1_EntoncesModificarEmpleado() {
        Perfil perfil = new Perfil();
        perfil.setEmpId(1);
        perfil.setCertificaciones("Certificado en Probar Mocos (En software)");
        perfil.setExperencias("Desarrollador Junior");
        perfil.setHabilidades("Trabajo bajo presión");

        when(repository.findById(1)).thenReturn(Optional.of(perfil));
        when(repository.save(any(Perfil.class))).thenReturn(perfil);

        Perfil perfilActualizado = new Perfil();
        perfilActualizado.setCertificaciones("Nuevo certificado");
        perfilActualizado.setExperencias("Nueva experiencia");
        perfilActualizado.setHabilidades("Nueva habilidad");

        boolean result = perfilesService.modificarPerfil(1, perfilActualizado);

        assertTrue(result);
        assertEquals(perfilActualizado.getCertificaciones(), perfil.getCertificaciones());
        assertEquals(perfilActualizado.getExperencias(), perfil.getExperencias());
        assertEquals(perfilActualizado.getHabilidades(), perfil.getHabilidades());

        verify(repository, times(1)).save(perfil);
    }
}