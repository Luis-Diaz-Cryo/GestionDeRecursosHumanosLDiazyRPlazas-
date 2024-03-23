package co.edu.unisabana.demo.repository;

import co.edu.unisabana.demo.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Rol, String> {
}
