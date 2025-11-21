package edu.alumno.adria.api_rest_bd_futbol.srv.impl;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.alumno.adria.api_rest_bd_futbol.model.db.JugadorDb;
import edu.alumno.adria.api_rest_bd_futbol.model.dto.JugadorList;
import edu.alumno.adria.api_rest_bd_futbol.model.dto.PaginaDto;
import edu.alumno.adria.api_rest_bd_futbol.repository.JugadorRepository;
import edu.alumno.adria.api_rest_bd_futbol.srv.JugadorService;
import edu.alumno.adria.api_rest_bd_futbol.srv.mapper.JugadorMapper;

@Service
public class JugadorServiceImpl implements JugadorService{
   
    private final JugadorRepository jugadorRepository;

    public JugadorServiceImpl(JugadorRepository jugadoresRepository) {
        this.jugadorRepository = jugadoresRepository;
    }

    @Override
    public PaginaDto<JugadorList> findAll(Pageable paging) {
        Page<JugadorDb> paginaJugadorDb = jugadorRepository.findAll(paging);
        return new PaginaDto<JugadorList>(
            paginaJugadorDb.getNumber(),
            paginaJugadorDb.getSize(),
            paginaJugadorDb.getTotalElements(),
            paginaJugadorDb.getTotalPages(),
            JugadorMapper.INSTANCE.jugadoresDbToJugadoresList(paginaJugadorDb.getContent()),
            paginaJugadorDb.getSort()
        );
    }
}
