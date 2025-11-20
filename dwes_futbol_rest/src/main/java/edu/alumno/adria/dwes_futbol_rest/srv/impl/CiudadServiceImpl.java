package edu.alumno.adria.dwes_futbol_rest.srv.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.alumno.adria.dwes_futbol_rest.model.db.CiudadDb;
import edu.alumno.adria.dwes_futbol_rest.model.dto.CiudadInfo;
import edu.alumno.adria.dwes_futbol_rest.model.dto.CiudadList;
import edu.alumno.adria.dwes_futbol_rest.model.dto.PaginaDto;
import edu.alumno.adria.dwes_futbol_rest.repository.CiudadRepository;
import edu.alumno.adria.dwes_futbol_rest.srv.CiudadService;
import edu.alumno.adria.dwes_futbol_rest.srv.mapper.CiudadMapper;
import io.micrometer.common.lang.NonNull;

@Service
public class CiudadServiceImpl implements CiudadService {
    private final CiudadRepository ciudadRepository;

    public CiudadServiceImpl(CiudadRepository ciudadRepository) {
        this.ciudadRepository=ciudadRepository;
    }

    public List<CiudadList> findAllCiudadList() {
        return CiudadMapper.INSTANCE.ciudadesToCiudadList(ciudadRepository.findAll());
    }

    public List<CiudadList> findAllCiudadList(@NonNull Sort sort) {
        return CiudadMapper.INSTANCE.ciudadesToCiudadList(ciudadRepository.findAll(sort));
    }

    public Optional<CiudadInfo> getCiudadInfoById(@NonNull Long id) {
        Optional<CiudadDb> ciudadDb=ciudadRepository.findById(id);
        if (ciudadDb.isPresent()) {
            return Optional.of(CiudadMapper.INSTANCE.CiudadDbToCiudadInfo(ciudadDb.get()));
        } else {
            return Optional.empty();
        }
    }

    public List<CiudadDb> findByNombreContaining(@NonNull String nombre, @NonNull Sort sort) {
        return ciudadRepository.findByNombreContaining(nombre, sort);
    }

    public PaginaDto<CiudadList> findAllPageCiudadList(@NonNull Pageable paging) {
        Page<CiudadDb> paginaCiudadDb = ciudadRepository.findAll(paging);
        return new PaginaDto<CiudadList>(
            paginaCiudadDb.getNumber(),
            paginaCiudadDb.getSize(),
            paginaCiudadDb.getTotalElements(),
            paginaCiudadDb.getTotalPages(),
            CiudadMapper.INSTANCE.ciudadesToCiudadList(paginaCiudadDb.getContent()),
            paginaCiudadDb.getSort()
        );
    }
     
    public PaginaDto<CiudadList> findByNombreContaining(@NonNull String nombre, @NonNull Pageable paging) {
        Page<CiudadDb> paginaCiudadDb = ciudadRepository.findByNombreContaining(nombre, paging);
        return new PaginaDto<CiudadList>(
            paginaCiudadDb.getNumber(),
            paginaCiudadDb.getSize(),
            paginaCiudadDb.getTotalElements(),
            paginaCiudadDb.getTotalPages(),
            CiudadMapper.INSTANCE.ciudadesToCiudadList(paginaCiudadDb.getContent()),
            paginaCiudadDb.getSort()
        );
    }
}
