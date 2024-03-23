package co.edu.unisabana.demo.Service;

import co.edu.unisabana.demo.Entity.Empleado;
import co.edu.unisabana.demo.Repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    private final EmpleadoRepository repository;


    @Autowired
    public EmpleadoService(EmpleadoRepository repository) {
        this.repository = repository;
    }

    public Empleado guardarEmpleado(Empleado empleado) {

        return repository.save(empleado);
    }

    public List<Empleado> consultarEmpleados() {
        return repository.findAll();
    }

    public Empleado consultarEmpleado(@PathVariable Integer id) {
        return repository.findById(id).orElse(null);
    }

    public boolean eliminarEmpleado(Integer id) {
        Optional<Empleado> empleadoOptional = repository.findById(id);
        if (empleadoOptional.isPresent()) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public boolean modificarEmpleado(Integer id, Empleado empleado) {
        Optional<Empleado> empleadoOptional = repository.findById(id);
        if (empleadoOptional.isPresent()) {
            Empleado existingEmpleado = empleadoOptional.get();
            existingEmpleado.setNombre(empleado.getNombre());
            existingEmpleado.setDireccion(empleado.getDireccion());
            existingEmpleado.setTelefono(empleado.getTelefono());
            existingEmpleado.setCargo(empleado.getCargo());
            repository.save(existingEmpleado);
            return true;
        } else {
            return false;
        }
    }
}