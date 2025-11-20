package org.alumno.adria.adria.primer_app_spring_boot.mvc;


import org.alumno.adria.adria.primer_app_spring_boot.model.dto.AlumnoEdit;
import org.alumno.adria.adria.primer_app_spring_boot.model.dto.ModuloEdit;
import org.alumno.adria.adria.primer_app_spring_boot.model.ram.Pagina;
import org.alumno.adria.adria.primer_app_spring_boot.srv.ModuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.validation.Valid;

@Controller
public class ModuloController {

	Pagina pagina = new Pagina("Modulos", "modulo-list");
	
	@Autowired
	ModuloService moduloService;
	
	@RequestMapping(value = {"/modulo-list"}, method=RequestMethod.GET)
	public String listarModulos(ModelMap model) {
		model.addAttribute("pagina", pagina);
		model.addAttribute("moduloList", moduloService.listaModulos());
		model.addAttribute("moduloEdit", new ModuloEdit());
		return "modulo-list";
	}
	
	@RequestMapping(value = {"/add-modulo"}, method=RequestMethod.POST)
	public String anyadirAlumno(ModelMap model, @Valid ModuloEdit moduloEdit, BindingResult validacion) {
		model.addAttribute("pagina", pagina);
		model.addAttribute("moduloList", moduloService.listaModulos());
		String errores = "";
		if (validacion.hasErrors()) {
			return "modulo-list";
		}
		
		try {
			moduloEdit.setId(moduloService.siguienteId());
			moduloService.addModulo(moduloEdit);
			model.clear();
			
			return "redirect:modulo-list";
		} catch (Exception e) {
			errores = e.toString();
		}
		model.addAttribute("errores", errores);
		return "modulo-list";
	}
}
