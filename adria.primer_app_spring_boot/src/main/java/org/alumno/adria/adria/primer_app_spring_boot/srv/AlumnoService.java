package org.alumno.adria.adria.primer_app_spring_boot.srv;

import java.util.ArrayList;
import java.util.List;

import org.alumno.adria.adria.primer_app_spring_boot.model.dto.AlumnoEdit;
import org.alumno.adria.adria.primer_app_spring_boot.model.dto.AlumnoList;
import org.alumno.adria.adria.primer_app_spring_boot.model.ram.Alumno;
import org.alumno.adria.adria.primer_app_spring_boot.srv.mapper.AlumnoMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

@Service
public class AlumnoService {
	
	private static List<Alumno> alumnos = new ArrayList <Alumno>();
	
	static {
		alumnos.add(new Alumno("11111111A", "Jose", 21, "DAM", 1));
		alumnos.add(new Alumno("22222222B", "Pedro", 32, "DAW", 2));
		alumnos.add(new Alumno("33333333C", "Juan", 23, "ASIX", 1));
	}
	
	public void addAlumno(AlumnoEdit alumnoEdit) throws Exception {
		if (alumnos.contains(new Alumno(alumnoEdit.getDni()))) {
			throw new Exception("Ya existe el alumno con dni " + alumnoEdit.getDni());
		} else {
			alumnos.add(AlumnoMapper.INSTANCE.alumnoEditToAlumno(alumnoEdit));
		}
	}
	
	public List<AlumnoList> listaAlumnos() {
		return AlumnoMapper.INSTANCE.alumnosToAlumnosList(alumnos);
	}
	
	public List<Alumno> borrarAlumno(String dni) {
		alumnos.remove(new Alumno(dni));
		
		return alumnos;
	}
	
	public Alumno encontrarAlumnoPorDni(String dni) {
		return alumnos.stream().filter(a -> a.getDni().equals(dni)).findFirst().orElse(null);
	
	}
	
	public void modificaAlumno(AlumnoEdit alumnoEdit) {
		Alumno alumno = AlumnoMapper.INSTANCE.alumnoEditToAlumno(alumnoEdit);
		int index = alumnos.indexOf(alumno);
		if (index != -1) {
			AlumnoMapper.INSTANCE.updateAlumnoFromAlumnoEdit(alumnoEdit, alumnos.get(index));
		}
	}
	
}
