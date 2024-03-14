package co.edu.unisabana.demo.Service;


import co.edu.unisabana.demo.Entity.Empleado;
import co.edu.unisabana.demo.Entity.Perfiles;
import co.edu.unisabana.demo.Repository.PerfilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PerfilesService {

    private final PerfilesRepository repository;

    @Autowired
    public PerfilesService(PerfilesRepository repository) {
        this.repository = repository;
    }

    public void guardarPerfiles(@RequestBody Perfiles perfiles) {
        repository.save(perfiles);
    }

    public List<Perfiles> consultarPerfiles(){
        return repository.findAll();
    }

    public  Perfiles getPerfilByEmpleadoId(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
