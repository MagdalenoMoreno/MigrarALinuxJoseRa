package edu.alumno.adria.api_rest_bd_futbol.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.alumno.adria.api_rest_bd_futbol.helper.PaginationHelper;
import edu.alumno.adria.api_rest_bd_futbol.model.dto.ListadoRespuesta;
import edu.alumno.adria.api_rest_bd_futbol.model.dto.PaginaDto;
import edu.alumno.adria.api_rest_bd_futbol.model.dto.PorteroList;
import edu.alumno.adria.api_rest_bd_futbol.srv.PorteroService;

@RestController
@RequestMapping("/api/v1")
public class PorteroRestController {
    
    private PorteroService porteroService;

    public PorteroRestController(PorteroService porterosService) {
        this.porteroService = porterosService;
    }

    @GetMapping("/porteros")
    public ResponseEntity<ListadoRespuesta<PorteroList>> getAllJugadores(@RequestParam(defaultValue = "0") int page, 
                                                             @RequestParam(defaultValue = "3") int size,
                                                             @RequestParam(defaultValue = "idEquipo,asc") String[] sort) { 
            
            Pageable pageable = PaginationHelper.createPageable(page, size, sort);
    
            PaginaDto<PorteroList> paginaPorterosList = porteroService.findAll(pageable);
            
            ListadoRespuesta<PorteroList> response = new ListadoRespuesta<>(
                paginaPorterosList.getNumber(),
                paginaPorterosList.getSize(),
                paginaPorterosList.getTotalElements(),
                paginaPorterosList.getTotalPages(),
                paginaPorterosList.getContent()
            );

            return ResponseEntity.ok(response);
    }
    
}
