package edu.alumno.adria.api_rest_bd_futbol.srv.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.alumno.adria.api_rest_bd_futbol.model.db.PorteroDb;
import edu.alumno.adria.api_rest_bd_futbol.model.dto.JugadorList;
import edu.alumno.adria.api_rest_bd_futbol.model.dto.PaginaDto;
import edu.alumno.adria.api_rest_bd_futbol.model.dto.PorteroList;
import edu.alumno.adria.api_rest_bd_futbol.repository.PorteroRepository;
import edu.alumno.adria.api_rest_bd_futbol.srv.PorteroService;
import edu.alumno.adria.api_rest_bd_futbol.srv.mapper.PorteroMapper;

@Service
public class PorteroServiceImpl implements PorteroService{
    
    private final PorteroRepository porteroRepository;

    public PorteroServiceImpl(PorteroRepository porterosRepository) {
        this.porteroRepository = porterosRepository;
    }

    public PaginaDto<PorteroList> findAll(Pageable paging) {
        Page<PorteroDb> paginaPorteroDb = porteroRepository.findAll(paging);
        return new PaginaDto<PorteroList>(
            paginaPorteroDb.getNumber(),
            paginaPorteroDb.getSize(),
            paginaPorteroDb.getTotalElements(),
            paginaPorteroDb.getTotalPages(),
            PorteroMapper.INSTANCE.porteroDbToPorteroList(paginaPorteroDb.getContent()),
            paginaPorteroDb.getSort()
        );
    }

}
