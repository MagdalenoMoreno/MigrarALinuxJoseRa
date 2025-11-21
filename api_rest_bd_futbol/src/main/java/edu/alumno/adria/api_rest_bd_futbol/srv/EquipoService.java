package edu.alumno.adria.api_rest_bd_futbol.srv;

import org.springframework.data.domain.Pageable;

import edu.alumno.adria.api_rest_bd_futbol.model.dto.EquipoList;
import edu.alumno.adria.api_rest_bd_futbol.model.dto.PaginaDto;
import io.micrometer.common.lang.NonNull;

public interface EquipoService {
    public PaginaDto<EquipoList> findAll(@NonNull Pageable paging);
}
