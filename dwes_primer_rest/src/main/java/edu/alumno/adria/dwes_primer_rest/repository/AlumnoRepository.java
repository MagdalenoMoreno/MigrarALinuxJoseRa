package edu.alumno.adria.dwes_primer_rest.repository;

import java.util.Collection;

import org.hibernate.cache.spi.support.CollectionReadOnlyAccess;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.alumno.adria.dwes_primer_rest.model.db.AlumnoDb;

@Repository
public interface AlumnoRepository extends JpaRepository<AlumnoDb, String> {
    @Query("SELECT a FROM AlumnoDb a WHERE a.ciclo='DAW'")
    Collection<AlumnoDb> findAllAlumnoDbDAW();
    @Query(value="SELECT * FROM alumnos as a WHERE a.ciclo='DAM'", nativeQuery = true)
    Collection<AlumnoDb> findAllAlumnoDbDAM();

    @Query("SELECT a FROM AlumnoDb a WHERE a.ciclo=:ciclo")
    Collection<AlumnoDb> findAllAlumnoDbCiclo(@Param("ciclo") String ciclo);
    @Query(value="SELECT * FROM alumnos as a WHERE a.ciclo=: AND a.pais=:pais", nativeQuery = true)
    Collection<AlumnoDb> findAllAlumnoDbCicloPais(@Param("ciclo") String ciclo, @Param("pais") String pais);

    @Query(value="SELECT * FROM alumnos as a WHERE a.dni = :dni", nativeQuery = true)
    Collection<AlumnoDb> findByDni(String dni);
    @Query(value="SELECT * FROM alumnos as a WHERE a.ciclo = :ciclo", nativeQuery = true)
    Collection<AlumnoDb> findByCiclo(String ciclo);
    @Query(value="SELECT * FROM alumnos as a WHERE a.horario = :horario", nativeQuery = true)
    Collection<AlumnoDb> findByHorario(String horario);
    @Query(value="SELECT * FROM alumnos as a WHERE a.edad = :edad", nativeQuery = true)
    Collection<AlumnoDb> findByEdad(Integer edad);
    @Query(value="SELECT * FROM alumnos as a WHERE a.ciclo = :ciclo AND a.pais = :pais", nativeQuery = true)
    Collection<AlumnoDb> findByCicloAndPais(String ciclo, String pais); 
    @Query(value="SELECT * FROM alumnos as a WHERE a.nombre NOT LIKE :nombre", nativeQuery = true)
    Collection<AlumnoDb> findDisctintByNombre(String nombre);
    @Query(value="SELECT * FROM alumnos as a WHERE a.nombre LIKE :nombre", nativeQuery = true)
    Collection<AlumnoDb> findByNombreIgnoreCase(String nombre);
    @Query(value="SELECT * FROM alumnos as a WHERE a.ciclo = :ciclo AND a.pais = :pais", nativeQuery = true)
    Collection<AlumnoDb> findByCicloAndPaisAllIgnoreCase(String ciclo, String pais);
    @Query(value="SELECT * FROM alumnos as a WHERE a.nombre LIKE :nombre", nativeQuery = true)
    Collection<AlumnoDb> findByNombreLike(String nombre);

    @Query("SELECT a FROM AlumnoDb a WHERE a.ciclo=:ciclo ORDER BY a.curso ASC")
    Collection<AlumnoDb> findAllAlumnoDbCicloOrderByCurso(@Param("ciclo") String ciclo);
    @Query("SELECT a FROM AlumnoDb a WHERE a.ciclo=:ciclo")
    Collection<AlumnoDb> findByCicloOrderBy(String ciclo, Sort sort);
    @Query("SELECT a FROM AlumnoDb a WHERE a.edad=:edad")
    Collection<AlumnoDb> findByEdadOrderBy(String edad, Sort sort);

    Collection<AlumnoDb> findByCiclo(String ciclo, Sort sort);
    Collection<AlumnoDb> findByHorario(String horario, Sort sort);
    Collection<AlumnoDb> findByEdad(Integer edad, Sort sort);



}
