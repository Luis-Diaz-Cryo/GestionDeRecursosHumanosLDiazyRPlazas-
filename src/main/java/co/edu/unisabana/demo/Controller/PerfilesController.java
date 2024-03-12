package co.edu.unisabana.demo.Controller;

import co.edu.unisabana.demo.Service.PerfilesService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PerfilesController {

    private final PerfilesService service;

    public PerfilesController(PerfilesService service) {
        this.service = service;
    }
}
