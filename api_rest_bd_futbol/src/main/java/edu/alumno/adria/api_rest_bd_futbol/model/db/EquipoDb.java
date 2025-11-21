package edu.alumno.adria.api_rest_bd_futbol.model.db;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "equipos")
public class EquipoDb implements Serializable{
    private static final long serialVersionUID = -818542778373595260L;
    @Id
    @Size(min = 3, message = "El id tiene un tamaño mínimo de 3 carácteres")
    private String id;
    @Size(min = 3, max = 20, message = "El nombre corto debe tener entre 3 y 20 carácteres")
    @Column(name = "nombrecorto")
    private String nombreCorto;
    @Size(min = 10, max = 40, message = "El nombre largo debe tener entre 10 y 40 carácteres")
    @Column(name = "`nombrelargo`")
    private String nombreLargo;
    @ManyToOne
    @JoinColumn(name = "ciudad")
    private CiudadDb ciudadDb;
    @Size(min = 10, max = 30, message = "El nombre del entrenador debe de tener entre 10 y 30 carácteres")
    private String entrenador;
    @Size(min = 10, max = 30, message = "El nombre del estadio debe de tener entre 10 y 30 carácteres")
    private String estadio;
    @Size(min = 4, max = 30, message = "El nombre de la marca debe de tener entre 4 y 30 carácteres")
    private String marca;
    @Size(min = 4, max = 30, message = "El nombre del patrocinador debe de tener entre 4 y 30 carácteres")
    private String patrocinador;
    private Long presupuesto;


}
