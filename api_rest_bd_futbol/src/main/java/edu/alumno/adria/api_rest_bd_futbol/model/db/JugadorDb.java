package edu.alumno.adria.api_rest_bd_futbol.model.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@IdClass(JugadorId.class)
@Table(name = "jugadores")
public class JugadorDb {
    private static final long serialVersionUID = -818542778373595260L;
    @Id
    @Size(min = 3, message = "El id del equipo tiene un tamaño mínimo de 3 carácteres")
    private String idEquipo;
    @Id
    @Column(nullable = false)
    private Long dorsal;
    @Size(min = 10, max = 30, message = "El nombre debe tener un tamaño de entre 10 y 30 carácteres")
    private String nombre;
    @Size(max = 10, message = "El nombre debe tener un tamaño máximo de 10 carácteres")
    private String posicion;
    private Long sueldo;
}
