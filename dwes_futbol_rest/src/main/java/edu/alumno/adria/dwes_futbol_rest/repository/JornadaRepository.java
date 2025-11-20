package edu.alumno.adria.dwes_futbol_rest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.alumno.adria.dwes_futbol_rest.model.db.JornadaDb;
import io.micrometer.common.lang.NonNull;

@Repository
public interface JornadaRepository extends JpaRepository<JornadaDb, Long> {
    @NonNull List<JornadaDb> findAll(@NonNull Sort sort);
    @NonNull List<JornadaDb> findJornadasByNum(@NonNull Long num, @NonNull Sort sort);
    @NonNull Optional<JornadaDb> findJornadasByNum(@NonNull Long num);
    Page<JornadaDb> findJornadasPageByNum(@NonNull Long num, @NonNull Pageable pageable);

    @NonNull List<JornadaDb> findAllBy(@NonNull Pageable pageable);
}
