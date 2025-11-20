package org.alumno.adria.adria.primer_app_spring_boot.mvc;

import java.util.List;

import org.alumno.adria.adria.primer_app_spring_boot.model.ram.Alumno;
import org.alumno.adria.adria.primer_app_spring_boot.model.ram.DocAlumno;
import org.alumno.adria.adria.primer_app_spring_boot.model.ram.Pagina;
import org.alumno.adria.adria.primer_app_spring_boot.srv.AlumnoService;
import org.alumno.adria.adria.primer_app_spring_boot.srv.DocAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
public class DocAlumnoController {
	
	Pagina pagina = new Pagina("Alumnos", "list-alumnos");
	
	@Autowired
	AlumnoService alumnoService;
	
	@Autowired
	DocAlumnoService docService;
	
	@RequestMapping(value= {"/doc-alumno"}, method=RequestMethod.GET)
	public String docAlumno(ModelMap model, @RequestParam String dni) {
		model.addAttribute("pagina", pagina);
		Alumno alumno = alumnoService.encontrarAlumnoPorDni(dni);
		model.addAttribute("alumno", alumno);
		model.addAttribute("docAlumno", new DocAlumno());
		model.addAttribute("docsAlumnos", docService.listaDocAlumnosPorDni(dni));
		return "doc-alumno";
	}
	
	@RequestMapping(value= {"/add-docAlumno"}, method=RequestMethod.POST)
	public String addDocAlumno(ModelMap model, @Valid DocAlumno docAlumno, BindingResult validacion) {
		model.addAttribute("pagina", pagina);
		
		String dni = docAlumno.getDni();

		if (validacion.hasErrors()) {
			model.addAttribute("pagina", pagina);
			model.addAttribute("dni", dni);
			model.addAttribute("alumno", alumnoService.encontrarAlumnoPorDni(dni));
			model.addAttribute("opcionesTipoDoc", docService.listaTipoDoc());
			model.addAttribute("docsAlumnos", docService.listaDocAlumnosPorDni(dni));
			return "doc-alumno";
		}
		
		String errores = "";
		try {
			docAlumno.setId(docService.siguienteId(dni));
			docService.addDocAlumno(docAlumno);
		} catch (Exception e) {
			errores = e.toString();
		}
		model.addAttribute("docsAlumnos", docService.listaDocAlumnosPorDni(dni));
		model.addAttribute("alumno", alumnoService.encontrarAlumnoPorDni(dni));
		model.addAttribute("docAlumno", new DocAlumno(docService.siguienteId(dni)));
		model.addAttribute("errores", errores);
		return "doc-alumno";
	}
	
	@ModelAttribute("opcionesTipoDoc")
	public List<String> getListaTipoDoc() {
		return docService.listaTipoDoc();
	}
	
}
