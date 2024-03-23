package co.edu.unisabana.demo.Repository;

import co.edu.unisabana.demo.Entity.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilesRepository extends JpaRepository<Perfil, Integer> {
}
