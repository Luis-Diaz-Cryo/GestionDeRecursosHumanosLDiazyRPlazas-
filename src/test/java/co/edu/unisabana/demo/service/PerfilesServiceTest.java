package co.edu.unisabana.demo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import co.edu.unisabana.demo.entity.Perfil;
import co.edu.unisabana.demo.repository.PerfilesRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class PerfilesServiceTest {

    private PerfilesService perfilesService;

    @Mock
    private PerfilesRepository repository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        perfilesService = new PerfilesService(repository);
    }

    @Test
    public void dadoPerfil_cuandoId1_entoncesMostrarPerfilEmpleado1(){
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


}