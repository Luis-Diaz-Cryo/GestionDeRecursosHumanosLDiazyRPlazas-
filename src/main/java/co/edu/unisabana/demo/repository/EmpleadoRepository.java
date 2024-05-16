package co.edu.unisabana.demo.repository;

import co.edu.unisabana.demo.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

}
