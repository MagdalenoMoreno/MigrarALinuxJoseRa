package org.alumno.adria.adria.primer_app_spring_boot.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModuloList {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nombre;
	private Integer horas;
	private String abreviatura;
	
	public ModuloList() {
		
	}
	
}
