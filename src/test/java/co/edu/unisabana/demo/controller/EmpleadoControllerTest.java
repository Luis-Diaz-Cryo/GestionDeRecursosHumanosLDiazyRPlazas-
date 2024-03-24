package co.edu.unisabana.demo.controller;

import co.edu.unisabana.demo.Entity.Empleado;
import co.edu.unisabana.demo.service.EmpleadoService;
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

@WebMvcTest(co.edu.unisabana.demo.controller.EmpleadoController.class)
@AutoConfigureMockMvc
class EmpleadoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmpleadoService empleadoService;

    @Test
    void dadoEmpleado_cuandoGuardarEmpleado_entoncesRetornaCreado() throws Exception {
        Empleado empleado = new Empleado();
        when(empleadoService.guardarEmpleado(empleado)).thenReturn(empleado);

        mockMvc.perform(MockMvcRequestBuilders.post("/empleado")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void dadoEmpleadoInvalido_cuandoGuardarEmpleado_entoncesRetornaBadRequests() throws Exception {
        Empleado empleado = new Empleado();
        mockMvc.perform(MockMvcRequestBuilders.post("/empleado")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{invalid_field: value}"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void dadoNoHayDatos_cuandoConsultarEmpleados_entoncesRetornaListaVacia() throws Exception {
        when(empleadoService.consultarEmpleados()).thenReturn(Collections.emptyList());

        mockMvc.perform(MockMvcRequestBuilders.get("/empleados"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void dadoIdEmpleado_cuandoConsultarEmpleado_entoncesRetornaEmpleado() throws Exception {
        int id = 1;
        when(empleadoService.consultarEmpleado(id)).thenReturn(new Empleado());

        mockMvc.perform(MockMvcRequestBuilders.get("/empleado/{id}", id))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void dadoIdEmpleado_cuandoEliminarEmpleado_entoncesRetornaOk() throws Exception {
        int id = 1;
        when(empleadoService.eliminarEmpleado(id)).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.delete("/empleado/borrar/{id}", id))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void dadoIdEmpleadoYDatos_cuandoModificarEmpleado_entoncesRetornaOk() throws Exception {
        int id = 1;
        Empleado empleado = new Empleado();
        when(empleadoService.modificarEmpleado(id, empleado)).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.put("/empleado/modi/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
