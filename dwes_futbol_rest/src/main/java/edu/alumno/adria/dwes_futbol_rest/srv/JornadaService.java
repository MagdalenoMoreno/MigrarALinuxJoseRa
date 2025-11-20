package edu.alumno.adria.dwes_futbol_rest.srv;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import edu.alumno.adria.dwes_futbol_rest.model.dto.JornadaInfo;
import edu.alumno.adria.dwes_futbol_rest.model.dto.JornadaList;
import edu.alumno.adria.dwes_futbol_rest.model.dto.PaginaDto;
import io.micrometer.common.lang.NonNull;

public interface JornadaService {
    
    public Optional<JornadaInfo> getJornadaInfoByNum(@NonNull Long num);
    public List<JornadaList> findAllJornadaList();
    public List<JornadaList> findAllJornadaList(@NonNull Sort sort);
    public PaginaDto<JornadaList> findAllPageJornadaList(@NonNull Pageable paging);
    public PaginaDto<JornadaList> findJornadaListByNum(@NonNull Long num, @NonNull Pageable paging);
}
