package edu.alumno.adria.api_rest_bd_futbol.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.alumno.adria.api_rest_bd_futbol.helper.PaginationHelper;
import edu.alumno.adria.api_rest_bd_futbol.model.dto.EquipoList;
import edu.alumno.adria.api_rest_bd_futbol.model.dto.JugadorList;
import edu.alumno.adria.api_rest_bd_futbol.model.dto.ListadoRespuesta;
import edu.alumno.adria.api_rest_bd_futbol.model.dto.PaginaDto;
import edu.alumno.adria.api_rest_bd_futbol.srv.JugadorService;

@RestController
@RequestMapping("/api/v1")
public class JugadorRestController {
    
    private JugadorService jugadorService;

    public JugadorRestController(JugadorService jugadoresService) {
        this.jugadorService = jugadoresService;
    }

    @GetMapping("/jugadores")
    public ResponseEntity<ListadoRespuesta<JugadorList>> getAllJugadores(@RequestParam(defaultValue = "0") int page, 
                                                             @RequestParam(defaultValue = "3") int size,
                                                             @RequestParam(defaultValue = "idEquipo,asc") String[] sort) { 
            
            Pageable pageable = PaginationHelper.createPageable(page, size, sort);
    
            PaginaDto<JugadorList> paginaJugadoresList = jugadorService.findAll(pageable);
            
            ListadoRespuesta<JugadorList> response = new ListadoRespuesta<>(
                paginaJugadoresList.getNumber(),
                paginaJugadoresList.getSize(),
                paginaJugadoresList.getTotalElements(),
                paginaJugadoresList.getTotalPages(),
                paginaJugadoresList.getContent()
            );

            return ResponseEntity.ok(response);
    }

}
