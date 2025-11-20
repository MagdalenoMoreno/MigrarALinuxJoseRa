package edu.alumno.adria.dwes_primer_rest.controller;
import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.alumno.adria.dwes_primer_rest.repository.AlumnoRepository;
import edu.alumno.adria.dwes_primer_rest.service.AlumnoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import edu.alumno.adria.dwes_primer_rest.model.dto.AlumnoEdit;
import edu.alumno.adria.dwes_primer_rest.model.dto.AlumnoInfo;
import edu.alumno.adria.dwes_primer_rest.model.dto.AlumnoList;
import edu.alumno.adria.dwes_primer_rest.exception.AlumnoNotFoundExcepcion;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/")
public class AlumnoRestController {

    private final AlumnoRepository alumnoRepository;

    private AlumnoService alumnoService;

    public AlumnoRestController(AlumnoService alumnoService, AlumnoRepository alumnoRepository) {
        this.alumnoService=alumnoService;
        this.alumnoRepository = alumnoRepository;
    }

    @GetMapping("/alumnos")
    public List<AlumnoList> getAlumnosList() {
        return alumnoService.findAllAlumnosList();
    }

    @PostMapping("/alumnos")
    public AlumnoEdit newAlumnoEdit(@Valid @RequestBody AlumnoEdit alumnoEdit) {
        return alumnoService.save(alumnoEdit);
    }

    @Operation(summary = "Get a Student by its DNI")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Found the Student",
        content = { @Content(mediaType = "application/json", schema = @Schema(implementation = AlumnoEdit.class))}),
    @ApiResponse(responseCode = "404", description = "Student not found", content = @Content)
    })

    @GetMapping("/alumnos/{dni}")
    public ResponseEntity<AlumnoEdit> getAlumnoEditByDni(
    @Parameter(description = "Dni of Student to be searched") @PathVariable(value = "dni") String dni) throws RuntimeException {
        Optional<AlumnoEdit> alumnoEdit = alumnoService.getAlumnoEditByDni(dni);
        if (alumnoEdit.isPresent())
            return ResponseEntity.ok().body(alumnoEdit.get());
        else throw new AlumnoNotFoundExcepcion("STUDENT_NOT_FOUND","Student with DNI "+ dni+ " not found");
    }

    @GetMapping("/alumnos/{dni}/info")
    public ResponseEntity<AlumnoInfo> getAlumnoInfoByDni(
    @PathVariable(value = "dni") String dni) throws RuntimeException {
        Optional<AlumnoInfo> alumnoInfo = alumnoService.getAlumnoInfoByDni(dni);
        if (alumnoInfo.isPresent()) {
            return ResponseEntity.ok().body(alumnoInfo.get());
        } else throw new AlumnoNotFoundExcepcion("STUDENT_NOT_FOUND","Student with DNI "+ dni+ " not found");
    }
    
    @PutMapping("/alumnos/{dni}")
    public ResponseEntity<AlumnoEdit> updateAlumnoEdit(
    @PathVariable(value = "dni") String dni,
    @Valid @RequestBody AlumnoEdit alumnoEdit) throws RuntimeException {
        Optional<AlumnoEdit> alumnoEdit2 = alumnoService.getAlumnoEditByDni(dni);
        if (alumnoEdit2.isPresent()) {
            return ResponseEntity.ok().body(alumnoService.update(alumnoEdit).get());
        } else throw new AlumnoNotFoundExcepcion("STUDENT_NOT_FOUND","Student with DNI "+ dni+ " not found");
    }  
    
    @DeleteMapping("/alumnos/{dni}")
    public String deleteByDni(@PathVariable(value = "dni") String dni) {
        return "";
    } 

    @GetMapping("/alumnosDAM")
    public List<AlumnoList> getAlumnosListDAM() {
        return alumnoService.findAllAlumnosListDAM();
    }

    @GetMapping("/alumnosDAW")
    public List<AlumnoList> getAlumnosListDAW() {
        return alumnoService.findAllAlumnosListDAW();
    }

    @GetMapping("/alumnos/ciclo/{ciclo}")
    public List<AlumnoList> getAlumnosListCiclo(@PathVariable("ciclo") String ciclo) {
        return alumnoService.findAllAlumnosListCiclo(ciclo);
    }
    
    @GetMapping("/alumnos/ciclo/{ciclo}/pais/{pais}")
    public List<AlumnoList> getAlumnosListCicloPais(@PathVariable("ciclo") String ciclo, @PathVariable("pais") String pais) {
        return alumnoService.findAllAlumnosListCicloPais(ciclo,pais);
    }


    @GetMapping("/alumnosList/dni/{dni}")
    public List<AlumnoList> getAlumnosListByDni(@PathVariable("dni") String dni) {
        return alumnoService.findAlumnosListByDni(dni);
    }

    @GetMapping("/alumnosList/ciclo/{ciclo}")
    public List<AlumnoList> getAlumnosListByCiclo(@PathVariable("ciclo") String ciclo) {
        return alumnoService.findAlumnosListByCiclo(ciclo);
    }

    @GetMapping("/alumnosList/horario/{horario}")
    public List<AlumnoList> getAlumnosListByHorario(@PathVariable("horario") String horario){
        return alumnoService.findAlumnosListByHorario(horario);
    }

    @GetMapping("/alumnosList/edad/{edad}")
    public List<AlumnoList> getAlumnosListByEdad(@PathVariable("edad") Integer edad) {
        return alumnoService.findAlumnosListByEdad(edad);
    }

    @GetMapping("/alumnosList/cicloAndPais/{ciclo}/{pais}")
    public List<AlumnoList> getAlumnosListByCicloAndPais(@PathVariable("ciclo") String ciclo, @PathVariable("pais") String pais) {
        return alumnoService.findAlumnosListByCicloAndPais(ciclo, pais);
    }

    @GetMapping("/alumnosList/distinctByNombre/{nombre}")
    public List<AlumnoList> getAlumnosListDisctintByNombre(@PathVariable("nombre") String nombre) {
        return alumnoService.findAlumnosListDisctintByNombre("%" + nombre + "%");
    }

    @GetMapping("/alumnosList/nombreIgnoreCase/{nombre}")
    public List<AlumnoList> getAlumnosListByNombreIgnoreCase(@PathVariable("nombre") String nombre) {
        return alumnoService.findAlumnosListByNombreIgnoreCase("%" + nombre + "%");
    }

    @GetMapping("/alumnosList/cicloAndPaisAllIgnoreCase/{ciclo}/{pais}")
    public List<AlumnoList> getAlumnosListByCicloAndPaisAllIgnoreCase(@PathVariable("ciclo") String ciclo, @PathVariable("pais") String pais) {
        return alumnoService.findAlumnosListByCicloAndPaisAllIgnoreCase(ciclo.toUpperCase(), pais.toUpperCase());
    }

    @GetMapping("/alumnosList/nombreLike/{nombre}")
    public List<AlumnoList> getAlumnosListByNombreLike(@PathVariable("nombre") String nombre) {
        return alumnoService.findAlumnosListByNombreLike("%" + nombre + "%");
    }

    /*@GetMapping("/alumnos/ciclo/{ciclo}/OrderByCurso")
    public List<AlumnoList> getAlumnosListCicloOrderByCurso(@PathVariable("ciclo") String ciclo) {
        return alumnoService.findAllAlumnosListCicloOrderByCurso(ciclo);
    }*/

    @GetMapping("/alumnosList/ciclo/{ciclo}/OrderBy/{atributoOrden}/{direccion}")
    public List<AlumnoList> getAlumnosListByCicloOrderBy(@PathVariable("ciclo") String ciclo, 
    @PathVariable("atributoOrden") String atributoOrden,
    @PathVariable("direccion") String direccion) {
        if (direccion.isEmpty()) {
            direccion = "ASC";
        }
        
        return alumnoService.findByCicloOrderBy(ciclo, Sort.by(Direction.fromString(direccion), atributoOrden));
    }
    
    @GetMapping("/alumnosList/edad/{edad}/OrderBy/{atributoOrden}/{direccion}")
    public List<AlumnoList> getAlumnosListEdadOrderBy(@PathVariable("edad") String edad, 
                                                      @PathVariable("atributoOrden") String atributoOrden,
                                                      @PathVariable("direccion") String direccion) {
        if (direccion.isEmpty()) {
            direccion = "ASC";
        }
        
        return alumnoService.findByEdadOrderBy(edad, Sort.by(Direction.fromString(direccion), atributoOrden));
    }


    @GetMapping("/alumnos/ciclo/{ciclo}/OrderBy/{atributoOrden}/{direccion}")
    public List<AlumnoList> getAlumnosByCicloOrderBy(@PathVariable("ciclo") String ciclo,
                                                     @PathVariable("atributoOrden") String atributoOrden,
                                                     @PathVariable("direccion") String direccion) {
        if (direccion.isEmpty()) {
            direccion = "ASC";
        }
        return alumnoService.findByCiclo(ciclo, Sort.by(Direction.fromString(direccion), atributoOrden));
    }
    
    
    
    
}