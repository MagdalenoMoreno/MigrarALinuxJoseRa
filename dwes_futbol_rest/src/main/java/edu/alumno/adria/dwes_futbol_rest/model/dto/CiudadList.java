package edu.alumno.adria.dwes_futbol_rest.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CiudadList implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nombre;
	private Long habitantes;

}
