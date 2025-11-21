package edu.alumno.adria.api_rest_bd_futbol.model.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PorteroInfo {
    @Size(min = 3, message = "El id tiene un tamaño mínimo de 3")
    private String idEquipo;
    private Long dorsal;
    private String nombre;
    
}

