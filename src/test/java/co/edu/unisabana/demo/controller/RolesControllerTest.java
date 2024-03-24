package co.edu.unisabana.demo.controller;

import co.edu.unisabana.demo.Entity.Rol;
import co.edu.unisabana.demo.service.RolesService;
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


@WebMvcTest(co.edu.unisabana.demo.controller.RolesController.class)
@AutoConfigureMockMvc
class RolesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RolesService rolesService;

    @Test
    void dadoRole_cuandoGuardarRole_entoncesRetornaOk() throws Exception {
        Rol rol = new Rol();
        when(rolesService.guardarRoles(rol)).thenReturn(rol);

        mockMvc.perform(MockMvcRequestBuilders.post("/role")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void dadoRoleInvalido_cuandoGuardarRole_entoncesRetornaBadRequest() throws Exception {
        Rol rol = new Rol();
        when(rolesService.guardarRoles(rol)).thenReturn(rol);

        mockMvc.perform(MockMvcRequestBuilders.post("/role")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{invalid_field: value}"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void dadoNoHayDatos_cuandoConsultarRoles_entoncesRetornaListaVacia() throws Exception {
        when(rolesService.consultarRoles()).thenReturn(Collections.emptyList());
        mockMvc.perform(MockMvcRequestBuilders.get("/roles"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void dadoNombreRole_cuandoConsultarRole_entoncesRetornaRole() throws Exception {
        String nombre = "exampleRole";
        when(rolesService.consultarRole(nombre)).thenReturn(new Rol());

        mockMvc.perform(MockMvcRequestBuilders.get("/role/{nombre}", nombre))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void dadoNombreRole_cuandoEliminarRole_entoncesRetornaOk() throws Exception {
        String nombre = "exampleRole";
        when(rolesService.eliminarRole(nombre)).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.delete("/role/borrar/{nombre}", nombre))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void dadoNombreRoleYDatos_cuandoModificarRole_entoncesRetornaOk() throws Exception {
        String nombre = "exampleRole";
        Rol rol = new Rol();
        when(rolesService.modificarRole(nombre, rol)).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.put("/role/modi/{nombre}", nombre)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}