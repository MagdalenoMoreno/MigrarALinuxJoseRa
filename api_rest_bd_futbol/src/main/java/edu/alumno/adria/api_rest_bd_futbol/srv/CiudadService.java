package edu.alumno.adria.api_rest_bd_futbol.srv;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import edu.alumno.adria.api_rest_bd_futbol.model.db.CiudadDb;
import edu.alumno.adria.api_rest_bd_futbol.model.dto.CiudadInfo;
import edu.alumno.adria.api_rest_bd_futbol.model.dto.CiudadList;
import edu.alumno.adria.api_rest_bd_futbol.model.dto.PaginaDto;
import io.micrometer.common.lang.NonNull;

public interface CiudadService {
    public CiudadInfo getCiudadInfoById(@NonNull Long id);
    public List<CiudadList> findAllCiudadList();
    public List<CiudadList> findAllCiudadList(@NonNull Sort sort);
    public PaginaDto<CiudadList> findAllPageCiudadList(@NonNull Pageable paging);
    public PaginaDto<CiudadList> findByNombreContaining(@NonNull String nombre, @NonNull Pageable paging);
    public List<CiudadDb> findByNombreContaining(@NonNull String nombre, @NonNull Sort sort);
    public PaginaDto<CiudadList> findAll(@NonNull Pageable paging);

}