package org.alumno.adria.adria.primer_app_spring_boot.srv.mapper;

import java.util.List;

import org.alumno.adria.adria.primer_app_spring_boot.model.dto.ModuloEdit;
import org.alumno.adria.adria.primer_app_spring_boot.model.dto.ModuloList;
import org.alumno.adria.adria.primer_app_spring_boot.model.ram.Modulo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ModuloMapper {

	ModuloMapper INSTANCE = Mappers.getMapper(ModuloMapper.class);
	
	List<ModuloList> moduloToModuloList(List<Modulo> modulo);
	
	Modulo moduloEditToModulo(ModuloEdit moduloEdit);
	
	ModuloEdit moduloToModuloEdit(Modulo modulo);
	
}
