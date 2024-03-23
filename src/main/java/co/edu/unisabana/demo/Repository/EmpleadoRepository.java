package co.edu.unisabana.demo.Repository;

import co.edu.unisabana.demo.Entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
}
