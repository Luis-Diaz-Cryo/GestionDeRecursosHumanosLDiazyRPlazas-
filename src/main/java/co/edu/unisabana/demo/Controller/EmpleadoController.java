package co.edu.unisabana.demo.Controller;


import co.edu.unisabana.demo.Entity.Empleado;
import co.edu.unisabana.demo.Service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController

public class EmpleadoController {
    private final EmpleadoService service;

    @Autowired
    public EmpleadoController(EmpleadoService service) {
        this.service = service;
    }

    @PostMapping("/empleado")
    public ResponseEntity<Empleado> guardarEmpleado(@RequestBody Empleado empleado) {
        Empleado newempleado = service.guardarEmpleado(empleado);

        return ResponseEntity.status(HttpStatus.CREATED).body(newempleado);
    }

    @GetMapping("/empleados")
    public List<Empleado> consultarEmpleados() {
        return service.consultarEmpleados();
    }

    @GetMapping("empleado/{id}")
    public Empleado consultarEmpleado(@PathVariable Integer id) {
        return service.consultarEmpleado(id);

    }

    @DeleteMapping("/empleado/borrar/{id}")
    public ResponseEntity<String> eliminarEmpleado(@PathVariable Integer id) {
        boolean deleted = service.eliminarEmpleado(id);
        if (deleted) {
            return new ResponseEntity<>("El empleado ha sido eliminado correctamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("El empleado no pudo ser encontrado o eliminado", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/empleado/modi/{id}")
    public ResponseEntity<String> modificarEmpleado(@PathVariable Integer id, @RequestBody Empleado empleado) {
        boolean updated = service.modificarEmpleado(id, empleado);
        if (updated) {
            return new ResponseEntity<>("El empleado ha sido modificado correctamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("El empleado no pudo ser encontrado o modificado", HttpStatus.NOT_FOUND);
        }
    }


}
