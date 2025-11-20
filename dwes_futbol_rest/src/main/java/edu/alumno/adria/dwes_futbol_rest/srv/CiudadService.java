package edu.alumno.adria.dwes_futbol_rest.srv;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import edu.alumno.adria.dwes_futbol_rest.model.db.CiudadDb;
import edu.alumno.adria.dwes_futbol_rest.model.dto.CiudadInfo;
import edu.alumno.adria.dwes_futbol_rest.model.dto.CiudadList;
import edu.alumno.adria.dwes_futbol_rest.model.dto.PaginaDto;
import io.micrometer.common.lang.NonNull;

public interface CiudadService {
    public Optional<CiudadInfo> getCiudadInfoById(@NonNull Long id);
    public List<CiudadList> findAllCiudadList();
    public List<CiudadList> findAllCiudadList(@NonNull Sort sort);
    public PaginaDto<CiudadList> findAllPageCiudadList(@NonNull Pageable paging);
    public PaginaDto<CiudadList> findByNombreContaining(@NonNull String nombre, @NonNull Pageable paging);
    public List<CiudadDb> findByNombreContaining(@NonNull String nombre, @NonNull Sort sort);

}
