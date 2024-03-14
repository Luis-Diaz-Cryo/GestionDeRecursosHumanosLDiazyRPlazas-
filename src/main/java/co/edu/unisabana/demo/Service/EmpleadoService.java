package co.edu.unisabana.demo.Service;

import co.edu.unisabana.demo.Entity.Empleado;
import co.edu.unisabana.demo.Repository.EmpleadoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class EmpleadoService {

    private final EmpleadoRepository repository;

    public EmpleadoService(EmpleadoRepository repository){
        this.repository = repository;
    }

    public void guardarEmpleado(Empleado empleado) {
    }

    public List<Empleado> consultarEmpleados(){
        return repository.findAll();
    }

    public Empleado consultarEmpleado(@PathVariable Integer id){
        return repository.findById(id).orElse(null);
    }
}



