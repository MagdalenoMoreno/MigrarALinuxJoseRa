package edu.alumno.adria.api_rest_bd_futbol.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.alumno.adria.api_rest_bd_futbol.model.db.RolDb;
import edu.alumno.adria.api_rest_bd_futbol.model.enums.RolNombre;

public interface RolRepository extends JpaRepository<RolDb, Integer>{
    Optional<RolDb> findByNombre(RolNombre rolNombre);
}
