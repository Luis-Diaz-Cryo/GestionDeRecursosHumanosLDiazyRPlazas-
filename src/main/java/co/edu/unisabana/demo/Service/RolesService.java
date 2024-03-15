package co.edu.unisabana.demo.Service;

import co.edu.unisabana.demo.Entity.Perfiles;
import co.edu.unisabana.demo.Entity.Roles;
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

    public void guardarRoles(Roles roles) {
        repository.save(roles);
    }

    public List<Roles> consultarRoles() {
        return repository.findAll();
    }

    public Roles consultarRole(@PathVariable String nombre) {
        return repository.findById(nombre).orElse(null);
    }

    public boolean eliminarRole(String nombre) {
        Optional<Roles> rolesOptional = repository.findById(nombre);
        if (rolesOptional.isPresent()) {
            repository.deleteById(nombre);
            return true;
        } else {
            return false;
        }
    }

    public boolean modificarRole(String nombre, Roles roles) {
        Optional<Roles> rolesOptional = repository.findById(nombre);
        if (rolesOptional.isPresent()) {
            Roles existingRoles = rolesOptional.get();
            existingRoles.setResponsibilidades(roles.getResponsibilidades());
            repository.save(existingRoles);
            return true;
        } else {
            return false;
        }
    }

}
