package edu.alumno.adria.api_rest_bd_futbol.srv.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.alumno.adria.api_rest_bd_futbol.model.db.UsuarioDb;
import edu.alumno.adria.api_rest_bd_futbol.model.dto.LoginUsuario;
import edu.alumno.adria.api_rest_bd_futbol.model.dto.UsuarioInfo;
import edu.alumno.adria.api_rest_bd_futbol.repository.UsuarioRepository;
import edu.alumno.adria.api_rest_bd_futbol.srv.UsuarioService;
import edu.alumno.adria.api_rest_bd_futbol.srv.mapper.UsuarioMapper;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    private UsuarioRepository usuarioRepository ;

    public UsuarioServiceImpl(UsuarioRepository usuariosRepository) {
        this.usuarioRepository = usuariosRepository;
    }

    @Override
    public Optional<UsuarioInfo> getsByNickname(String nickname) {
        Optional<UsuarioDb> usuarioDb = usuarioRepository.findByNickname(nickname);
        if (usuarioDb.isPresent()) {
            return Optional.of(UsuarioMapper.INSTANCE.usuarioDbToUsuarioInfo(usuarioDb.get()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public boolean existsByNickname(String nickname) {
        return usuarioRepository.existsByNickname(nickname);
    }

    @Override
    public boolean existsByEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    @Override
    public boolean comprobarLogin(LoginUsuario loginUsuario) {
        Optional<UsuarioDb> usuarioDb = usuarioRepository.findByNickname(loginUsuario.getNickname());
        if (usuarioDb.isPresent()) {
            UsuarioDb usuario = usuarioDb.get();
            return usuario.getPassword().equals(loginUsuario.getPassword());
        } else {
            return false;
        }
    }
    
}
