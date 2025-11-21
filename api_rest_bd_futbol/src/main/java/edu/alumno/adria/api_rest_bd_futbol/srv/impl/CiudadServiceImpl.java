package edu.alumno.adria.api_rest_bd_futbol.srv.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.alumno.adria.api_rest_bd_futbol.exception.CiudadNotFoundException;
import edu.alumno.adria.api_rest_bd_futbol.model.db.CiudadDb;
import edu.alumno.adria.api_rest_bd_futbol.model.dto.CiudadInfo;
import edu.alumno.adria.api_rest_bd_futbol.model.dto.CiudadList;
import edu.alumno.adria.api_rest_bd_futbol.model.dto.PaginaDto;
import edu.alumno.adria.api_rest_bd_futbol.repository.CiudadRepository;
import edu.alumno.adria.api_rest_bd_futbol.srv.CiudadService;
import edu.alumno.adria.api_rest_bd_futbol.srv.mapper.CiudadMapper;
import lombok.NonNull;

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

    public CiudadInfo getCiudadInfoById(Long id) {
        CiudadDb ciudadDb = ciudadRepository.findById(id).orElseThrow(() -> new CiudadNotFoundException("CIUDAD NOT FOUND", "Ciudad not found on :: " + id));
        return (CiudadMapper.INSTANCE.ciudadDbToCiudadInfo(ciudadDb));

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

    @Override
    public PaginaDto<CiudadList> findAll(@NonNull Pageable paging) {
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
}
