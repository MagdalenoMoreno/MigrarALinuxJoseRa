package edu.alumno.adria.api_rest_bd_futbol.model.db;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "ciudades")
public class CiudadDb implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 4, message = "El nombre debe de tener un tamaño mínimo de 4 carácteres")
    private String nombre;
    @Column(nullable = true)
    private Long habitantes;
    //mappedBy = "ciudadDb". En EquipoDb la clave ajena es el atributo ciudadDb
    @OneToMany(mappedBy = "ciudad")
    private Set<EquipoNombreDb> equiposNombresDb = new HashSet<>();
}