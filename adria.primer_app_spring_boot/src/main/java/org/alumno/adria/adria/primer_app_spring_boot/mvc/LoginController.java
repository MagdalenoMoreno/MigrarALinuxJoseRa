package org.alumno.adria.adria.primer_app_spring_boot.mvc;

import org.alumno.adria.adria.primer_app_spring_boot.model.dto.LoginEdit;
import org.alumno.adria.adria.primer_app_spring_boot.model.ram.Pagina;
import org.alumno.adria.adria.primer_app_spring_boot.srv.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("nombre")
public class LoginController {
	@Autowired
	LoginService loginservicio;
	Pagina pagina = new Pagina("Login", "login");
	
	@RequestMapping(value= {"/", "/login"}, method=RequestMethod.GET)
	public String mostrarLogin(ModelMap model) {
		model.addAttribute("pagina", pagina);
		model.addAttribute("loginEdit", new LoginEdit());
		return "login";
	}
	
	@RequestMapping(value= {"/", "/login"}, method=RequestMethod.POST)
	public String procesaLogin(ModelMap model, @Valid LoginEdit loginEdit, BindingResult validacion) {
		
		String errores = "";
		model.addAttribute("pagina", pagina);
		
		if (validacion.hasErrors()) {
			return "login";
		}
		
		if (loginservicio.usuarioValido(loginEdit.getNickname(), loginEdit.getPasswd())) {
			return "redirect:list-alumnos";
		} else {
			errores = "Usuario o contraseña incorrectos";
		}
		
		model.addAttribute("errores", errores);
		return "login";
		
	}
}