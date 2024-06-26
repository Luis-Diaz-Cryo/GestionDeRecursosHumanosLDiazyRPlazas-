package co.edu.unisabana.demo.controller;

import co.edu.unisabana.demo.entity.Perfil;
import co.edu.unisabana.demo.service.PerfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
public class PerfilesController {

    private final PerfilesService service;

    @Autowired
    public PerfilesController(PerfilesService service) {
        this.service = service;
    }

    @PostMapping("/perfil")
    public String guardarPerfiles(@RequestBody Perfil perfiles) {
        service.guardarPerfiles(perfiles);
        return "El perfil  ha sido guardado con éxito";
    }

    @GetMapping("/perfiles")
    public List<Perfil> consultarPerfiles() {
        return service.consultarPerfiles();
    }

    @GetMapping("/perfil/{empId}")
    public Perfil cosultarPerfil(@PathVariable Integer empId) {
        return service.consultarPerfil(empId);
    }

    @DeleteMapping("/perfil/borrar/{empId}")
    public ResponseEntity<String> eliminarPerfil(@PathVariable Integer empId) {
        boolean deleted = service.eliminarPerfil(empId);
        if (deleted) {
            return new ResponseEntity<>("El Perfil ha sido eliminado correctamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("El Perfil no pudo ser encontrado o eliminado", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/perfil/modi/{empId}")
    public ResponseEntity<String> modificarPerfil(@PathVariable Integer empId, @RequestBody Perfil perfiles) {
        boolean updated = service.modificarPerfil(empId, perfiles);
        if (updated) {
            return new ResponseEntity<>("El Perfil ha sido modificado correctamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("El Perfil no pudo ser encontrado o modificado", HttpStatus.NOT_FOUND);
        }
    }


}
