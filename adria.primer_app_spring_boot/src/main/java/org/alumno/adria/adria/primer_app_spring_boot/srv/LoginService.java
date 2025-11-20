package org.alumno.adria.adria.primer_app_spring_boot.srv;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	public boolean usuarioValido(String usuario, String password) {
		if (usuario.contentEquals("adria") && password.contentEquals("123456")) {
			return true;
		} else {
			return false;
		}
	}
}
