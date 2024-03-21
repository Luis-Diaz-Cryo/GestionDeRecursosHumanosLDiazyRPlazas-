package co.edu.unisabana.demo.service;


import co.edu.unisabana.demo.entity.Perfil;
import co.edu.unisabana.demo.repository.PerfilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilesService {

    private final PerfilesRepository repository;

    @Autowired
    public PerfilesService(PerfilesRepository repository) {
        this.repository = repository;
    }

    public void guardarPerfiles(Perfil perfiles) {
        repository.save(perfiles);
    }

    public List<Perfil> consultarPerfiles() {
        return repository.findAll();
    }

    public Perfil consultarPerfil(@PathVariable Integer id) {
        return repository.findById(id).orElse(null);
    }

    public boolean eliminarPerfil(Integer id) {
        Optional<Perfil> perfilesOptional = repository.findById(id);
        if (perfilesOptional.isPresent()) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public boolean modificarPerfil(Integer id, Perfil perfiles) {
        Optional<Perfil> perfilesOptional = repository.findById(id);
        if (perfilesOptional.isPresent()) {
            Perfil existingPerfil = perfilesOptional.get();
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


