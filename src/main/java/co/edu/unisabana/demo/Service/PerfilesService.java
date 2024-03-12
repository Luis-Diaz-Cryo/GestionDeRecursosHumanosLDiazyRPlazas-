package co.edu.unisabana.demo.Service;


import co.edu.unisabana.demo.Entity.Empleado;
import co.edu.unisabana.demo.Entity.Perfiles;
import co.edu.unisabana.demo.Repository.PerfilesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilesService {

    private final PerfilesRepository repository;

    public PerfilesService(PerfilesRepository repository) {
        this.repository = repository;
    }

    public void guardarPerfiles(Perfiles perfiles) {
    }

    public List<Perfiles> consultarPerfiles(){
        return repository.findAll();
    }
}
