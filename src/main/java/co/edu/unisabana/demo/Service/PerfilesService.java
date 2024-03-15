package co.edu.unisabana.demo.Service;


import co.edu.unisabana.demo.Entity.Empleado;
import co.edu.unisabana.demo.Entity.Perfiles;
import co.edu.unisabana.demo.Repository.PerfilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilesService {

    private final PerfilesRepository repository;

    @Autowired
    public PerfilesService(PerfilesRepository repository) {
        this.repository = repository;
    }

    public void guardarPerfiles(Perfiles perfiles) {
        repository.save(perfiles);
    }

    public List<Perfiles> consultarPerfiles() {
        return repository.findAll();
    }

    public Perfiles consultarPerfil(@PathVariable Integer id) {
        return repository.findById(id).orElse(null);
    }

    public boolean eliminarPerfil(Integer id) {
        Optional<Perfiles> perfilesOptional = repository.findById(id);
        if (perfilesOptional.isPresent()) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public boolean modificarPerfil(Integer id, Perfiles perfiles) {
        Optional<Perfiles> perfilesOptional = repository.findById(id);
        if (perfilesOptional.isPresent()) {
            Perfiles existingPerfil = perfilesOptional.get();
            existingPerfil.setHabilidades(perfiles.getHabilidades());
            existingPerfil.setExperencias(perfiles.getExperencias());
            existingPerfil.setCertificaciones(perfiles.getCertificaciones());
            repository.save(existingPerfil);
            return true;
        } else {
            return false;
        }
    }

}


