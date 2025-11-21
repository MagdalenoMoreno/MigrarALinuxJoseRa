package edu.alumno.adria.api_rest_bd_futbol.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.alumno.adria.api_rest_bd_futbol.model.db.CiudadDb;
import io.micrometer.common.lang.NonNull;

public interface CiudadRepository extends JpaRepository<CiudadDb, Long> {
    @NonNull List<CiudadDb> findAll(@NonNull Sort sort);
    @NonNull List<CiudadDb> findByNombreContaining(@NonNull String nombre, @NonNull Sort sort);
    Page<CiudadDb> findByNombreContaining(@NonNull String nombre, @NonNull Pageable pageable);

    @NonNull List<CiudadDb> findAllBy(@NonNull Pageable pageable);

}
