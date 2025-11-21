package edu.alumno.adria.api_rest_bd_futbol.srv.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import edu.alumno.adria.api_rest_bd_futbol.model.db.PorteroDb;
import edu.alumno.adria.api_rest_bd_futbol.model.dto.PorteroList;

@Mapper
public interface PorteroMapper {
    PorteroMapper INSTANCE = Mappers.getMapper(PorteroMapper.class);

    @Mapping(target = "nombre", source = "jugadorDb.nombre")
    PorteroList porteroDbToPorteroList(PorteroDb porterosDb);
    
    List <PorteroList> porteroDbToPorteroList(List<PorteroDb> porterosDb);
}
