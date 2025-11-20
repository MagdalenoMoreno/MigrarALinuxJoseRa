package org.alumno.adria.adria.primer_app_spring_boot.model.ram;

import java.util.Objects;

import org.alumno.adria.adria.primer_app_spring_boot.srv.DocAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class DocAlumno implements Comparable<DocAlumno>{

	@Pattern(regexp = "[0-9]{8}[A-Za-z]{1}", message = "El dni debe tener 8 números y una letra")
	private String dni;
	
	
	@NotNull(message = "El tipo no puede estar vacio")
	private String tipo;
	
	@Size(min = 10, message = "Los comentarios debe tener almenos 10 carácteres")
	private String comentario;
	

	private Integer id;

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DocAlumno other = (DocAlumno) obj;
		return Objects.equals(dni, other.dni) && Objects.equals(id, other.id);
	}
	
	public DocAlumno(
			@Pattern(regexp = "[0-9]{8}[A-Za-z]{1}", message = "El dni debe tener 8 números y una letra") String dni,
			Integer id, @NotNull(message = "El tipo no puede estar vacio") String tipo,
			@Size(min = 10, message = "Los comentarios debe tener almenos 10 carácteres") String comentario) {
		super();
		this.dni = dni;
		this.id = id;
		this.tipo = tipo;
		this.comentario = comentario;
	}

	public DocAlumno(Integer id) {
		super();
		this.id = id;
	}
	
	public DocAlumno() {
		
	}
	

	@Override
	public int compareTo(DocAlumno doc) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
