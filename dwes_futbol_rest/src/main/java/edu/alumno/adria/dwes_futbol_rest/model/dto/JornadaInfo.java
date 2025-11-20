package edu.alumno.adria.dwes_futbol_rest.model.dto;

import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class JornadaInfo implements Serializable{
	private Long num;
	private Date fecha;
}
