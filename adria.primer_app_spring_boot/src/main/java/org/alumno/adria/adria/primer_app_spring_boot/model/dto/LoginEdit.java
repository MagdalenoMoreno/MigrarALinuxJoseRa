package org.alumno.adria.adria.primer_app_spring_boot.model.dto;

import java.io.Serializable;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginEdit implements Serializable {
	@Size(min=3,message="El nombre debe de tener un tamaño mínimo de 3 carácteres") 
	private String nickname;
	
	@Size(min=5,message="El nombre debe de tener un tamaño mínimo de 5 carácteres") 
	private String passwd;
	
	public LoginEdit() {
		
	}
	
	public LoginEdit(String nickname, String passwd) {
		this.nickname = nickname;
		this.passwd = passwd;
	}
}
