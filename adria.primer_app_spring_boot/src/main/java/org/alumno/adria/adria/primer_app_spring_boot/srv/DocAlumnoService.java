package org.alumno.adria.adria.primer_app_spring_boot.srv;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.alumno.adria.adria.primer_app_spring_boot.model.ram.Alumno;
import org.alumno.adria.adria.primer_app_spring_boot.model.ram.DocAlumno;
import org.springframework.stereotype.Service;

@Service
public class DocAlumnoService {

	private static List<DocAlumno> docsAlumnos = new ArrayList <DocAlumno>();
	
	public List<DocAlumno> addDocAlumno(DocAlumno docalumno) throws Exception {
		
		boolean correcte = true;
		
		for (DocAlumno docAlumno2 : docsAlumnos) {
			if (docAlumno2.equals(docalumno)) {
				correcte = false;
			}
		}
		
		if (correcte) {
			docsAlumnos.add(docalumno);
		} else {
			System.out.println("adri bobo");
		}
		
		return docsAlumnos;
		
	}
	
	public List<DocAlumno> listaDocAlumnos() {
		return docsAlumnos;
	}
	
	public List<DocAlumno> listaDocAlumnosPorDni(String dni) {
		return docsAlumnos.stream().filter(a -> a.getDni().equals(dni)).collect(Collectors.toList());

	}
	
	public List<DocAlumno> borrarDocAlumno(int id) {
		docsAlumnos.remove(new DocAlumno(id));
		
		return docsAlumnos;
	}
	
	public List <String> listaTipoDoc() {
		List <String> opcionesTipoDoc = new ArrayList<String>();
		opcionesTipoDoc.add("Certificado");
		opcionesTipoDoc.add("Justificante");
		opcionesTipoDoc.add("Solicitud");
		return opcionesTipoDoc;
	}
	
	/*public int siguienteId(String dni) {
		return docsAlumnos.stream().filter(a -> a.getDni().equalsIgnoreCase(dni)).sorted((a, b) -> b.compareTo(a)).map(a -> a.getId()).findFirst().orElse(0);
	}*/
	
	public int siguienteId(String dni) {
	    return docsAlumnos.stream()
	            .filter(a -> a.getDni() != null && a.getDni().equalsIgnoreCase(dni))
	            .map(DocAlumno::getId)
	            .filter(Objects::nonNull) // por si algún id es null
	            .max(Integer::compareTo)  // más claro que sorted+findFirst
	            .orElse(0) + 1;
	}

	
}
