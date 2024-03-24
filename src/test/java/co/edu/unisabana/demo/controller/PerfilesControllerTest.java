package co.edu.unisabana.demo.controller;

import co.edu.unisabana.demo.Entity.Perfil;
import co.edu.unisabana.demo.service.PerfilesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

import static org.mockito.Mockito.when;


@WebMvcTest(co.edu.unisabana.demo.controller.PerfilesController.class)
@AutoConfigureMockMvc
class PerfilesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PerfilesService perfilService;

    @Test
    void dadoPerfil_cuandoGuardarPerfil_entoncesRetornaOk() throws Exception {
        Perfil perfil = new Perfil();
        when(perfilService.guardarPerfiles(perfil)).thenReturn(perfil);

        mockMvc.perform(MockMvcRequestBuilders.post("/perfil")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void dadoPerfilinvalido_cuandoGuardarPerfil_entoncesRetornaBadRequest() throws Exception {
        Perfil perfil = new Perfil();
        when(perfilService.guardarPerfiles(perfil)).thenReturn(perfil);

        mockMvc.perform(MockMvcRequestBuilders.post("/perfil")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{invalid_field: value}"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void dadoNoHayDatos_cuandoConsultarPerfiles_entoncesRetornaListaVacia() throws Exception {
        when(perfilService.consultarPerfiles()).thenReturn(Collections.emptyList());

        mockMvc.perform(MockMvcRequestBuilders.get("/perfiles"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void dadoIdPerfil_cuandoConsultarPerfil_entoncesRetornaPerfil() throws Exception {
        int id = 1;
        when(perfilService.consultarPerfil(id)).thenReturn(new Perfil());

        mockMvc.perform(MockMvcRequestBuilders.get("/perfil/{empId}", id))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void dadoIdPerfil_cuandoEliminarPerfil_entoncesRetornaOk() throws Exception {
        int id = 1;
        when(perfilService.eliminarPerfil(id)).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.delete("/perfil/borrar/{empId}", id))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void dadoIdPerfilYDatos_cuandoModificarPerfil_entoncesRetornaOk() throws Exception {
        int id = 1;
        Perfil perfil = new Perfil();
        when(perfilService.modificarPerfil(id, perfil)).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.put("/perfil/modi/{empId}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}