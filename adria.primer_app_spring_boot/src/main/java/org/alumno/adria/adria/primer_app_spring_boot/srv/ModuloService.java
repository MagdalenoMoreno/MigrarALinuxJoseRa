package org.alumno.adria.adria.primer_app_spring_boot.srv;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.alumno.adria.adria.primer_app_spring_boot.model.dto.ModuloEdit;
import org.alumno.adria.adria.primer_app_spring_boot.model.dto.ModuloList;
import org.alumno.adria.adria.primer_app_spring_boot.model.ram.DocAlumno;
import org.alumno.adria.adria.primer_app_spring_boot.model.ram.Modulo;
import org.alumno.adria.adria.primer_app_spring_boot.srv.mapper.ModuloMapper;
import org.springframework.stereotype.Service;

@Service
public class ModuloService {
	
	private static List<Modulo> modulos = new ArrayList<Modulo>();
	
	static {
		modulos.add(new Modulo(1, "Programación", 8, "PRO"));
		modulos.add(new Modulo(2, "Desarrollo Web en Entorno Servidor", 8, "DWES"));
	}
	
	public void addModulo(ModuloEdit moduloEdit) throws Exception {
		if (modulos.contains(new Modulo(moduloEdit.getId()))) {
			throw new Exception("Ya existe el modulo con Id: " + moduloEdit.getId());
		} else {
			modulos.add(ModuloMapper.INSTANCE.moduloEditToModulo(moduloEdit));
		}
	}
	
	public List <ModuloList> listaModulos() {
		return ModuloMapper.INSTANCE.moduloToModuloList(modulos);
	}
	
	public Modulo encontrarModuloPorId(Integer id) {
		return modulos.stream().filter(a -> a.getId().equals(id)).findFirst().orElse(null);
	}
	
	public int siguienteId() {
	    return modulos.reversed().stream().map(a -> a.getId()).findFirst().orElse(null) + 1;
	}
	
}
