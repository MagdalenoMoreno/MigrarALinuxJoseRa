package org.alumno.adria.adria.primer_app_spring_boot.mvc;

import org.alumno.adria.adria.primer_app_spring_boot.model.dto.AlumnoEdit;
import org.alumno.adria.adria.primer_app_spring_boot.model.ram.Alumno;
import org.alumno.adria.adria.primer_app_spring_boot.model.ram.Pagina;
import org.alumno.adria.adria.primer_app_spring_boot.srv.AlumnoService;
import org.alumno.adria.adria.primer_app_spring_boot.srv.mapper.AlumnoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
public class AlumnoController {
	
	Pagina pagina = new Pagina("Alumnos", "list-alumnos");
	
	@Autowired
	AlumnoService alumnoService;
	
	@RequestMapping(value= {"/list-alumnos"}, method=RequestMethod.GET)
	public String listarAlumnos(ModelMap model){
		model.addAttribute("alumnosList", alumnoService.listaAlumnos());
		model.put("pagina", pagina);
		return "list-alumnos";
	}
	
	@RequestMapping(value= {"/add-alumno"}, method=RequestMethod.GET)
	public String mostrarAlumno(ModelMap model){
		model.addAttribute("pagina", pagina);
		model.addAttribute("alumnoEdit", new AlumnoEdit());
		return "add-alumno";
	}
	
	@RequestMapping(value = {"/del-alumno"}, method = RequestMethod.GET)
	public String borrarAlumno(ModelMap model, @RequestParam String dni) {
		model.addAttribute("pagina", pagina);
		alumnoService.borrarAlumno(dni);
		return "redirect:list-alumnos";
	}
	
	@RequestMapping(value = {"/confirm-del"}, method = RequestMethod.GET)
	public String confirmBorrarAlumno(ModelMap model, @RequestParam String dni) {
		model.addAttribute("pagina", pagina);
		Alumno alumno = alumnoService.encontrarAlumnoPorDni(dni);
		model.addAttribute("alumno", alumno);
		return "confirm-del";
	}
	
	@RequestMapping(value = {"/mod-alumno"}, method = RequestMethod.GET)
	public String mostrarModificar(ModelMap model, @RequestParam String dni) {
		model.addAttribute("pagina", pagina);
		Alumno alumno = alumnoService.encontrarAlumnoPorDni(dni);
		model.addAttribute("alumnoEdit", AlumnoMapper.INSTANCE.alumnoToAlumnoEdit(alumno));
		return "modificar-alumno";
	}
	
	@RequestMapping(value = {"/modi-alumno"}, method = RequestMethod.POST)
	public String modificarAlumno(ModelMap model, @Valid AlumnoEdit alumnoEdit, BindingResult validacion) {
		model.addAttribute("pagina", pagina);
		model.addAttribute("alumnoEdit", alumnoEdit);
		if (validacion.hasErrors()) {
			return "modificar-alumno";
			
		}
		return "confirm-mod";
	}
	
	@RequestMapping(value = {"/confirm-modi"}, method = RequestMethod.POST)
	public String confirmModi(ModelMap model, @Valid AlumnoEdit alumnoEdit, BindingResult validacion) {
		model.addAttribute("pagina", pagina);
		alumnoService.modificaAlumno(alumnoEdit);
		return "redirect:list-alumnos";
	}
	
	
	@RequestMapping(value= {"/add-alumno"}, method=RequestMethod.POST)
	public String addAlumno(ModelMap model, @Valid AlumnoEdit alumnoEdit, BindingResult validacion){
		String errores = "";
		model.addAttribute("pagina", pagina);
		
		if (validacion.hasErrors()) {
			return "add-alumno";
		}
		
		try {
			alumnoService.addAlumno(alumnoEdit);
			model.clear();
			
			return "redirect:list-alumnos";
			
		} catch (Exception e) {
			errores = e.toString();
		}
		
		model.addAttribute("errores", errores);
		return "add-alumno";
	}
	
}
