package edu.alumno.adria.api_rest_bd_futbol.srv;

import java.util.Optional;

import edu.alumno.adria.api_rest_bd_futbol.model.dto.LoginUsuario;
import edu.alumno.adria.api_rest_bd_futbol.model.dto.UsuarioInfo;
import jakarta.annotation.Nonnull;

public interface UsuarioService {
    public Optional<UsuarioInfo> getsByNickname(@Nonnull String nickname);
    public boolean existsByNickname(@Nonnull String nickname);
    public boolean existsByEmail(@Nonnull String email);
    public boolean comprobarLogin(@Nonnull LoginUsuario loginUsuario);
}
