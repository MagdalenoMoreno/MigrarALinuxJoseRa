package edu.alumno.adria.api_rest_bd_futbol.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.alumno.adria.api_rest_bd_futbol.model.db.JugadorDb;
import edu.alumno.adria.api_rest_bd_futbol.model.db.JugadorId;
import io.micrometer.common.lang.NonNull;

public interface JugadorRepository extends JpaRepository<JugadorDb, JugadorId>{
    @NonNull Page<JugadorDb> findAll(@NonNull Pageable pageable);
}
