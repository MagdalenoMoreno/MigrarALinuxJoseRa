package edu.alumno.adria.api_rest_bd_futbol.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.alumno.adria.api_rest_bd_futbol.model.db.JugadorId;
import edu.alumno.adria.api_rest_bd_futbol.model.db.PorteroDb;
import io.micrometer.common.lang.NonNull;

public interface PorteroRepository extends JpaRepository<PorteroDb, JugadorId>{
    @NonNull Page<PorteroDb> findAll(@NonNull Pageable pageable);
}
