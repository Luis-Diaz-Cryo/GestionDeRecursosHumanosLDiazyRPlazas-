package co.edu.unisabana.demo.Service;

import co.edu.unisabana.demo.Entity.Rol;
import co.edu.unisabana.demo.Repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class RolesService {


    private final RolesRepository repository;

    @Autowired
    public RolesService(RolesRepository repository) {
        this.repository = repository;
    }

    public Rol guardarRoles(Rol roles){
        return repository.save(roles);
    }

    public List<Rol> consultarRoles() {
        return repository.findAll();
    }

    public Rol consultarRole(@PathVariable String nombre) {
        return repository.findById(nombre).orElse(null);
    }

    public boolean eliminarRole(String nombre) {
        Optional<Rol> rolesOptional = repository.findById(nombre);
        if (rolesOptional.isPresent()) {
            repository.deleteById(nombre);
            return true;
        } else {
            return false;
        }
    }

    public boolean modificarRole(String nombre, Rol roles) {
        Optional<Rol> rolesOptional = repository.findById(nombre);
        if (rolesOptional.isPresent()) {
            Rol existingRoles = rolesOptional.get();
            existingRoles.setResponsibilidades(roles.getResponsibilidades());
            repository.save(existingRoles);
            return true;
        } else {
            return false;
        }
    }

}
