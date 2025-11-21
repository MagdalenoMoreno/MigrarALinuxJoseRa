package edu.alumno.adria.api_rest_bd_futbol.model.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginUsuario {
    @Size(min = 5, message = "El nickname debe de tener un tamaño mñinimo de 5 carácteres")
    private String nickname;
    @Pattern(
        regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
        message = "La contraseña debe de tener al menos 8 carácteres, una mayúscula, una minúscula, un número y un carácter especial"
    )
    private String password;
}
