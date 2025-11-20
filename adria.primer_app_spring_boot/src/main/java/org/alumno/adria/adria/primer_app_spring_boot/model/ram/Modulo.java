package org.alumno.adria.adria.primer_app_spring_boot.model.ram;

import java.util.Objects;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Modulo implements Comparable <Modulo> {

	private Integer id;
	@Size(min = 5, message = "El nombre debe tener una longitud mínima de 5 carácteres")
	private String nombre;
	@Range(min = 2, max = 8, message = "Las horas deben estar contenidas entre 2 y 8")
	private Integer horas;
	@Size(min = 3, message = "La abreviatura debe tener una longitud de 3 carácteres", max = 3)
	private String abreviatura;
	
	public Modulo(Integer id, String nombre, Integer horas, String abreviatura) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.horas = horas;
		this.abreviatura = abreviatura;
	}
	
	public Modulo() {
		
	}
	
	public Modulo(Integer id) {
		super();
		this.id = id;
	}
	
	@Override
	public int compareTo(Modulo o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Modulo other = (Modulo) obj;
		return Objects.equals(id, other.id);
	}
	
}

