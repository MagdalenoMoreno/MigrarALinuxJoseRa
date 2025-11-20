package edu.alumno.adria.dwes_futbol_rest.srv.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.alumno.adria.dwes_futbol_rest.model.db.CiudadDb;
import edu.alumno.adria.dwes_futbol_rest.model.db.JornadaDb;
import edu.alumno.adria.dwes_futbol_rest.model.dto.CiudadList;
import edu.alumno.adria.dwes_futbol_rest.model.dto.JornadaInfo;
import edu.alumno.adria.dwes_futbol_rest.model.dto.JornadaList;
import edu.alumno.adria.dwes_futbol_rest.model.dto.PaginaDto;
import edu.alumno.adria.dwes_futbol_rest.repository.CiudadRepository;
import edu.alumno.adria.dwes_futbol_rest.repository.JornadaRepository;
import edu.alumno.adria.dwes_futbol_rest.srv.JornadaService;
import edu.alumno.adria.dwes_futbol_rest.srv.mapper.CiudadMapper;
import edu.alumno.adria.dwes_futbol_rest.srv.mapper.JornadaMapper;
import io.micrometer.common.lang.NonNull;

@Service
public class JornadaServiceImpl implements JornadaService{
     
    private final JornadaRepository jornadaRepository;

    public JornadaServiceImpl(JornadaRepository jornadaRepository) {
        this.jornadaRepository=jornadaRepository;
    }

    public Optional<JornadaInfo> getJornadaInfoByNum(@NonNull Long num) {
        Optional<JornadaDb> jornadaDb = jornadaRepository.findJornadasByNum(num);
        if (jornadaDb.isPresent()) {
            return Optional.of(JornadaMapper.INSTANCE.JornadaDbToJornadaInfo(jornadaDb.get()));
        } else {
            return Optional.empty();
        }
    }

    public List<JornadaList> findAllJornadaList() {
        return JornadaMapper.INSTANCE.JornadaToJornadaList(jornadaRepository.findAll());
    }


    public List<JornadaList> findAllJornadaList(@NonNull Sort sort) {
        return JornadaMapper.INSTANCE.JornadaToJornadaList(jornadaRepository.findAll(sort));
    }

    public PaginaDto<JornadaList> findAllPageJornadaList(@NonNull Pageable paging) {
        Page<JornadaDb> paginaJornadaDb = jornadaRepository.findAll(paging);
        return new PaginaDto<JornadaList>(
            paginaJornadaDb.getNumber(),
            paginaJornadaDb.getSize(),
            paginaJornadaDb.getTotalElements(),
            paginaJornadaDb.getTotalPages(),
            JornadaMapper.INSTANCE.JornadaToJornadaList(paginaJornadaDb.getContent()),
            paginaJornadaDb.getSort()
        );
    }

    @Override
    public PaginaDto<JornadaList> findJornadaListByNum(Long num, Pageable paging) {
        Page<JornadaDb> paginaJornadaDb = jornadaRepository.findJornadasPageByNum(num, paging);
        return new PaginaDto<JornadaList>(
            paginaJornadaDb.getNumber(),
            paginaJornadaDb.getSize(),
            paginaJornadaDb.getTotalElements(),
            paginaJornadaDb.getTotalPages(),
            JornadaMapper.INSTANCE.JornadaToJornadaList(paginaJornadaDb.getContent()),
            paginaJornadaDb.getSort()
        );
    }

}
