package edu.alumno.adria.dwes_futbol_rest.srv.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import edu.alumno.adria.dwes_futbol_rest.model.db.JornadaDb;
import edu.alumno.adria.dwes_futbol_rest.model.dto.JornadaInfo;
import edu.alumno.adria.dwes_futbol_rest.model.dto.JornadaList;

@Mapper
public interface JornadaMapper {
    JornadaMapper INSTANCE = Mappers.getMapper(JornadaMapper.class);

    JornadaInfo JornadaDbToJornadaInfo(JornadaDb JornadaDb);
    JornadaList JornadaDbToJornadaList(JornadaDb JornadaDb);
    List<JornadaList> JornadaToJornadaList(List<JornadaDb>JornadaDb);
}
