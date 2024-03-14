package co.edu.unisabana.demo.Controller;

import co.edu.unisabana.demo.Entity.Empleado;
import co.edu.unisabana.demo.Entity.Perfiles;
import co.edu.unisabana.demo.Service.PerfilesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PerfilesController {

    private final PerfilesService service;

    public PerfilesController(PerfilesService service) {
        this.service = service;
    }

    @PostMapping("/perfil")
    public String guardarPerfiles(@RequestBody Perfiles perfiles){
        service.guardarPerfiles(perfiles);
        return "El perfil  ha sido guardado con éxito";
    }

    @GetMapping("/perfiles")
    public List<Perfiles> consultarPerfiles(){
        return service.consultarPerfiles();
    }


}
