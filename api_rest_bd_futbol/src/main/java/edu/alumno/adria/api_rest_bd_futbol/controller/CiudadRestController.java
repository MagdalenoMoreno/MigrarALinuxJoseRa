package edu.alumno.adria.api_rest_bd_futbol.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import edu.alumno.adria.api_rest_bd_futbol.helper.PaginationHelper;
import edu.alumno.adria.api_rest_bd_futbol.model.db.CiudadDb;
import edu.alumno.adria.api_rest_bd_futbol.model.dto.CiudadInfo;
import edu.alumno.adria.api_rest_bd_futbol.model.dto.CiudadList;
import edu.alumno.adria.api_rest_bd_futbol.model.dto.ListadoRespuesta;
import edu.alumno.adria.api_rest_bd_futbol.model.dto.PaginaDto;
import edu.alumno.adria.api_rest_bd_futbol.srv.CiudadService;

import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/api/v1")
public class CiudadRestController {
    
    private final CiudadService ciudadService;
    
    public CiudadRestController(CiudadService ciudadservice) {
        this.ciudadService = ciudadservice;
    }

    /*@GetMapping("/ciudades")
    public Collection<CiudadList> getCiudadesList() {
        return ciudadService.findAllCiudadList();
    }*/

    @GetMapping("/ciudades/orden/{direccionOrden}")
    public Collection<CiudadList> getCiudadesListOrderByName(@PathVariable("direccionOrden") String direccionOrden) {
        return ciudadService.findAllCiudadList(Sort.by(Direction.fromString(direccionOrden), "nombre"));
    }
    
    @GetMapping("/ciudades/{id}/info")
    public ResponseEntity<CiudadInfo> getCiudadInfoById(@PathVariable(value = "id") Long id) {
        CiudadInfo ciudadInfo = ciudadService.getCiudadInfoById(id);
        return ResponseEntity.ok().body(ciudadInfo);
    }

    @GetMapping("ciudades/nombre/{nombre}/orden/{direccionOrden}")
    public List<CiudadDb> getCiudadByNombreContaining(@PathVariable(value = "nombre") String nombre, @PathVariable(value = "direccionOrden") String direccionOrden) {
        return ciudadService.findByNombreContaining(nombre, Sort.by(Direction.fromString(direccionOrden), "nombre"));
    }

    @GetMapping("/ciudades")
    public ResponseEntity<ListadoRespuesta<CiudadList>> getAllCiudades(
        @RequestParam(required = false) String nombre,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "3") int size,
        @RequestParam(defaultValue = "id,asc") String[] sort) {
            
            Pageable pageable = PaginationHelper.createPageable(page, size, sort);
    
            PaginaDto<CiudadList> paginaCiudadesList = ciudadService.findAll(pageable);
            
            ListadoRespuesta<CiudadList> response = new ListadoRespuesta<>(
                paginaCiudadesList.getNumber(),
                paginaCiudadesList.getSize(),
                paginaCiudadesList.getTotalElements(),
                paginaCiudadesList.getTotalPages(),
                paginaCiudadesList.getContent()
            );

            return ResponseEntity.ok(response);
    }  

}