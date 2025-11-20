package edu.alumno.adria.dwes_primer_rest.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;

import edu.alumno.adria.dwes_primer_rest.model.db.AlumnoDb;
import edu.alumno.adria.dwes_primer_rest.model.dto.AlumnoEdit;
import edu.alumno.adria.dwes_primer_rest.model.dto.AlumnoInfo;
import edu.alumno.adria.dwes_primer_rest.model.dto.AlumnoList;

public interface AlumnoService {
    public Optional<AlumnoEdit> getAlumnoEditByDni(String dni);
    public Optional<AlumnoInfo> getAlumnoInfoByDni(String dni);
    public AlumnoEdit save(AlumnoEdit alumnoEdit);
    public String deleteByDni(String dni);
    public Optional<AlumnoEdit> update(AlumnoEdit alumnoEdit);
    public List<AlumnoList> findAllAlumnosList();

    public List<AlumnoList> findAllAlumnosListDAW();
    public List<AlumnoList> findAllAlumnosListDAM();

    public List<AlumnoList> findAllAlumnosListCiclo(String ciclo);
    public List<AlumnoList> findAllAlumnosListCicloPais(String ciclo, String pais);

    public List<AlumnoList> findAlumnosListByDni(String dni);
    public List<AlumnoList> findAlumnosListByCiclo(String ciclo);
    public List<AlumnoList> findAlumnosListByHorario(String horario);
    public List<AlumnoList> findAlumnosListByEdad(Integer edad);
    public List<AlumnoList> findAlumnosListByCicloAndPais(String ciclo, String pais); 
    public List<AlumnoList> findAlumnosListDisctintByNombre(String nombre);
    public List<AlumnoList> findAlumnosListByNombreIgnoreCase(String nombre);
    public List<AlumnoList> findAlumnosListByCicloAndPaisAllIgnoreCase(String ciclo, String pais);
    public List<AlumnoList> findAlumnosListByNombreLike(String nombre);
    public List<AlumnoList> findAllAlumnosListCicloOrderByCurso(String ciclo);
    public List<AlumnoList> findByCicloOrderBy(String ciclo, Sort sort);
    public List<AlumnoList> findByEdadOrderBy(String edad, Sort sort);
    public List<AlumnoList> findByCiclo(String ciclo, Sort sort);
 }
