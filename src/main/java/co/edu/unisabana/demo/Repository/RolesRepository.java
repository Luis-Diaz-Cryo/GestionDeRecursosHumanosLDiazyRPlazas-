package co.edu.unisabana.demo.Repository;

import co.edu.unisabana.demo.Entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles, String> {
}
