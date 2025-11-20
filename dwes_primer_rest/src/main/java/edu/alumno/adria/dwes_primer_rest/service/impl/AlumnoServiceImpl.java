package edu.alumno.adria.dwes_primer_rest.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;

import edu.alumno.adria.dwes_primer_rest.model.db.AlumnoDb;
import edu.alumno.adria.dwes_primer_rest.model.dto.AlumnoEdit;
import edu.alumno.adria.dwes_primer_rest.model.dto.AlumnoInfo;
import edu.alumno.adria.dwes_primer_rest.model.dto.AlumnoList;
import edu.alumno.adria.dwes_primer_rest.repository.AlumnoRepository;
import edu.alumno.adria.dwes_primer_rest.service.AlumnoService;
import edu.alumno.adria.dwes_primer_rest.service.mapper.AlumnoMapper;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository alumnoRepository;

    public AlumnoServiceImpl(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    @Override
    public Optional<AlumnoEdit> getAlumnoEditByDni(String dni) {
        Optional<AlumnoDb> alumnoDb=alumnoRepository.findById(dni);
        if (alumnoDb.isPresent()) {
            AlumnoDb alumnodb = alumnoDb.get();
            AlumnoEdit alumnoedit = AlumnoMapper.INSTANCE.alumnoDbToAlumnoEdit(alumnodb);
            return Optional.of(alumnoedit);
        } else {
            return Optional.empty();
        } 
    }

    @Override
    public Optional<AlumnoInfo> getAlumnoInfoByDni(String dni) {
        Optional<AlumnoDb> alumnoDb=alumnoRepository.findById(dni);
        if (alumnoDb.isPresent()) {
            return Optional.of(AlumnoMapper.INSTANCE.alumnoDbToAlumnoInfo(alumnoDb.get()));
        } else {
            return Optional.empty();
        } 
    }

    @Override
    public AlumnoEdit save(AlumnoEdit alumnoEdit) {
        AlumnoDb alumnodb = AlumnoMapper.INSTANCE.alumnoEditToAlumnoDb(alumnoEdit);
        alumnoRepository.save(alumnodb);
        return AlumnoMapper.INSTANCE.alumnoDbToAlumnoEdit(alumnodb);
    }

    @Override
    public String deleteByDni(String dni) {
        return alumnoRepository.findById(dni)
        .map(a-> {
                alumnoRepository.deleteById(dni);
                return "Deleted";
            }).orElse("Not Deleted");
    }

    @Override
    public Optional<AlumnoEdit> update(AlumnoEdit alumnoEdit) {
        Optional<AlumnoDb> alumnoDb = alumnoRepository.findById(alumnoEdit.getDni());
        if (alumnoDb.isPresent()) {
            AlumnoDb alumnoModificadoDb = AlumnoMapper.INSTANCE.alumnoEditToAlumnoDb(alumnoEdit);
            alumnoRepository.save(alumnoModificadoDb);
            AlumnoEdit alumnoedit = AlumnoMapper.INSTANCE.alumnoDbToAlumnoEdit(alumnoModificadoDb);
            return Optional.of(alumnoedit);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<AlumnoList> findAllAlumnosList() {
        List<AlumnoDb> listaAlumnos = alumnoRepository.findAll();
        return AlumnoMapper.INSTANCE.alumnosToAlumnosList(listaAlumnos);
    }

    @Override
    public List <AlumnoList> findAllAlumnosListDAW() {
        return AlumnoMapper.INSTANCE.alumnosToAlumnosList((List<AlumnoDb>) alumnoRepository.findAllAlumnoDbDAW());
    }

    @Override
    public List<AlumnoList> findAllAlumnosListDAM() {
        return AlumnoMapper.INSTANCE.alumnosToAlumnosList((List<AlumnoDb>) alumnoRepository.findAllAlumnoDbDAM());
    }

    @Override
    public List<AlumnoList> findAllAlumnosListCiclo(String ciclo) {
        return AlumnoMapper.INSTANCE.alumnosToAlumnosList((List<AlumnoDb>) alumnoRepository.findAllAlumnoDbCiclo(ciclo));
    }

    @Override
    public List<AlumnoList> findAllAlumnosListCicloPais(String ciclo, String pais) {
        return AlumnoMapper.INSTANCE.alumnosToAlumnosList((List<AlumnoDb>) alumnoRepository.findAllAlumnoDbCicloPais(ciclo, pais));
    }

    @Override
    public List<AlumnoList> findAlumnosListByDni(String dni) {
        return AlumnoMapper.INSTANCE.alumnosToAlumnosList((List<AlumnoDb>) alumnoRepository.findByDni(dni));
    }

    @Override
    public List<AlumnoList> findAlumnosListByCiclo(String ciclo) {
        return AlumnoMapper.INSTANCE.alumnosToAlumnosList((List<AlumnoDb>) alumnoRepository.findByCiclo(ciclo));
    }

    @Override
    public List<AlumnoList> findAlumnosListByHorario(String horario) {
        return AlumnoMapper.INSTANCE.alumnosToAlumnosList((List<AlumnoDb>) alumnoRepository.findByHorario(horario));
    }

    @Override
    public List<AlumnoList> findAlumnosListByEdad(Integer edad) {
        return AlumnoMapper.INSTANCE.alumnosToAlumnosList((List<AlumnoDb>) alumnoRepository.findByEdad(edad));
    }

    @Override
    public List<AlumnoList> findAlumnosListByCicloAndPais(String ciclo, String pais) {
        return AlumnoMapper.INSTANCE.alumnosToAlumnosList((List<AlumnoDb>) alumnoRepository.findByCicloAndPais(ciclo, pais));
    }

    @Override
    public List<AlumnoList> findAlumnosListDisctintByNombre(String nombre) {
        return AlumnoMapper.INSTANCE.alumnosToAlumnosList((List<AlumnoDb>) alumnoRepository.findDisctintByNombre(nombre));
    }

    @Override
    public List<AlumnoList> findAlumnosListByNombreIgnoreCase(String nombre) {
        return AlumnoMapper.INSTANCE.alumnosToAlumnosList((List<AlumnoDb>) alumnoRepository.findByNombreIgnoreCase(nombre));
    }

    @Override
    public List<AlumnoList> findAlumnosListByCicloAndPaisAllIgnoreCase(String ciclo, String pais) {
        return AlumnoMapper.INSTANCE.alumnosToAlumnosList((List<AlumnoDb>) alumnoRepository.findByCicloAndPaisAllIgnoreCase(ciclo, pais));
    }

    @Override
    public List<AlumnoList> findAlumnosListByNombreLike(String nombre) {
        return AlumnoMapper.INSTANCE.alumnosToAlumnosList((List<AlumnoDb>) alumnoRepository.findByNombreLike(nombre));
    }

    @Override
    public List<AlumnoList> findByCicloOrderBy(String ciclo, Sort sort) {
        return AlumnoMapper.INSTANCE.alumnosToAlumnosList((List<AlumnoDb>) alumnoRepository.findByCicloOrderBy(ciclo, sort));
    }

    @Override
    public List<AlumnoList> findAllAlumnosListCicloOrderByCurso(String ciclo) {
        return AlumnoMapper.INSTANCE.alumnosToAlumnosList((List<AlumnoDb>) alumnoRepository.findAllAlumnoDbCicloOrderByCurso(ciclo));
    }

    @Override
    public List<AlumnoList> findByEdadOrderBy(String edad, Sort sort) {
        return AlumnoMapper.INSTANCE.alumnosToAlumnosList((List<AlumnoDb>) alumnoRepository.findByEdadOrderBy(edad, sort));
    }

    @Override
    public List<AlumnoList> findByCiclo(String ciclo, Sort sort) {
        return AlumnoMapper.INSTANCE.alumnosToAlumnosList((List<AlumnoDb>) alumnoRepository.findByCiclo(ciclo, sort));
    }
}
