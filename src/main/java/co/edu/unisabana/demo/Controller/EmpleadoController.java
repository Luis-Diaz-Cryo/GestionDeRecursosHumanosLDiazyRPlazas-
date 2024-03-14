package co.edu.unisabana.demo.Controller;


import co.edu.unisabana.demo.Entity.Empleado;
import co.edu.unisabana.demo.Service.EmpleadoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpleadoController {
    private final EmpleadoService service;

    public EmpleadoController(EmpleadoService service) {
        this.service = service;
    }

    @PostMapping("/empleado")
    public String guardarEmpleado(@RequestBody Empleado empleado){
        service.guardarEmpleado(empleado);
        return "El empleado ha sido guardado con éxito";
    }

    @GetMapping("/empleados")
    public List<Empleado> consultarEmpleados(){
        return service.consultarEmpleados();
    }

    @GetMapping("empleado/{id}")
    public Empleado consultarEmpleado(@PathVariable Integer id){
        return service.consultarEmpleado(id);

    }


}
