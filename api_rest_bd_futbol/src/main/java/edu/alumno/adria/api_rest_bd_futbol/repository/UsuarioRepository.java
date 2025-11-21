package edu.alumno.adria.api_rest_bd_futbol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.alumno.adria.api_rest_bd_futbol.model.db.UsuarioDb;
import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<UsuarioDb, Long>{
    Optional<UsuarioDb> findByNickname(String nickname);
    boolean existsByNickname(String nickname);
    boolean existsByEmail(String email);
}
