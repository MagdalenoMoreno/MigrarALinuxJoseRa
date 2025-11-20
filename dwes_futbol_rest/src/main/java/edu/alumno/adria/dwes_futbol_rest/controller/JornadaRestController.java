package edu.alumno.adria.dwes_futbol_rest.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.alumno.adria.dwes_futbol_rest.model.dto.JornadaInfo;
import edu.alumno.adria.dwes_futbol_rest.model.dto.JornadaList;
import edu.alumno.adria.dwes_futbol_rest.model.dto.PaginaDto;
import edu.alumno.adria.dwes_futbol_rest.srv.JornadaService;
import edu.alumno.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api/v1")
public class JornadaRestController {
    private final JornadaService jornadaService;
    
    public JornadaRestController(JornadaService jornadaService) {
        this.jornadaService = jornadaService;
    }

    @GetMapping("/jornadas/orden/{direccionOrden}")
    public Collection<JornadaList> getJornadasListNum(@PathVariable("direccionOrden") String direccionOrden) {
        return jornadaService.findAllJornadaList(Sort.by(Direction.fromString(direccionOrden), "num"));
    }
    
    @GetMapping("/jornadas/{num}/num")
    public ResponseEntity<JornadaInfo> getJornadaByNum(@PathVariable(value = "num") Long num) throws RuntimeException {
        Optional<JornadaInfo> jornadaInfo = jornadaService.getJornadaInfoByNum(num);
        if (jornadaInfo.isPresent()) {
            return ResponseEntity.ok().body(jornadaInfo.get());
        } else throw new ResourceNotFoundException("Jornada not found on :: " + num);
    }

    @GetMapping("/jornadas")
    public ResponseEntity<Map<String, Object>> getAllJornadas(
        @RequestParam(required = false) Long num,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "3") int size,
        @RequestParam(defaultValue = "num,asc") String[] sort) {
        

        try {

            List<Order> criteriosOrdenacion = new ArrayList<Order>();

            if(sort[0].contains(",")) {
                for(String criterioOrdenacion : sort) {
                    String[] orden = criterioOrdenacion.split(",");
                    if (orden.length > 1) {
                        criteriosOrdenacion.add(new Order(Direction.fromString(orden[1]), orden[0]));
                    } else {
                        criteriosOrdenacion.add(new Order(Direction.fromString("asc"), orden[0]));
                    }
                }

            } else {
                criteriosOrdenacion.add(new Order(Direction.fromString(sort[1]), sort[0]));
            }

            Sort sorts = Sort.by(criteriosOrdenacion);
            
            Pageable paging = PageRequest.of(page, size, sorts);
    
            PaginaDto<JornadaList> paginaJornadasList;
            if (num == null) {
                paginaJornadasList = jornadaService.findAllPageJornadaList(paging);
            } else {
                paginaJornadasList = jornadaService.findJornadaListByNum(num, paging);
            }

            List<JornadaList> jornadas = paginaJornadasList.getContent();
            Map<String, Object> response = new HashMap<>();
            response.put("data", jornadas);
            response.put("currentPage", paginaJornadasList.getNumber());
            response.put("pageSize", paginaJornadasList.getSize());
            response.put("totalItems", paginaJornadasList.getTotalElements());
            response.put("totalPages", paginaJornadasList.getTotalPages());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("message", "Se produjo un error interno en el servidor");
            errorResponse.put("details", e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
