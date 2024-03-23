package co.edu.unisabana.demo.Controller;


import co.edu.unisabana.demo.Entity.Rol;
import co.edu.unisabana.demo.Service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class RolesController {

    private final RolesService service;


    @Autowired
    public RolesController(RolesService service) {
        this.service = service;
    }

    @PostMapping("/role")
    public String guardarRole(@RequestBody Rol roles) {
        service.guardarRoles(roles);
        return "El role  ha sido guardado con éxito";
    }

    @GetMapping("/roles")
    public List<Rol> consultarRoles() {
        return service.consultarRoles();
    }

    @GetMapping("/role/{nombre}")
    public Rol cosultarRolel(@PathVariable String nombre) {
        return service.consultarRole(nombre);
    }

    @DeleteMapping("/role/borrar/{nombre}")
    public ResponseEntity<String> eliminarRole(@PathVariable String nombre) {
        boolean deleted = service.eliminarRole(nombre);
        if (deleted) {
            return new ResponseEntity<>("El Role ha sido eliminado correctamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("El Role no pudo ser encontrado o eliminado", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/role/modi/{nombre}")
    public ResponseEntity<String> modificarRole(@PathVariable String nombre, @RequestBody Rol roles) {
        boolean updated = service.modificarRole(nombre, roles);
        if (updated) {
            return new ResponseEntity<>("El Role ha sido modificado correctamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("El Role no pudo ser encontrado o modificado", HttpStatus.NOT_FOUND);
        }
    }

}
