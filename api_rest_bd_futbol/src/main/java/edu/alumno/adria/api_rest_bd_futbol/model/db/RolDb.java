package edu.alumno.adria.api_rest_bd_futbol.model.db;

import edu.alumno.adria.api_rest_bd_futbol.model.enums.RolNombre;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "roles")
public class RolDb{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RolNombre nombre;
}
