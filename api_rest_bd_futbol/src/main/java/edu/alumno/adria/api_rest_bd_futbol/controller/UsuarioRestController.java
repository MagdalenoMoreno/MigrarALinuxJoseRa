package edu.alumno.adria.api_rest_bd_futbol.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.alumno.adria.api_rest_bd_futbol.model.dto.LoginUsuario;
import edu.alumno.adria.api_rest_bd_futbol.model.dto.UsuarioInfo;
import edu.alumno.adria.api_rest_bd_futbol.srv.UsuarioService;
import jakarta.validation.Valid;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("api/usuarios")
public class UsuarioRestController {
    private final UsuarioService usuarioService;

    public UsuarioRestController(UsuarioService usuariosService) {
        this.usuarioService = usuariosService;
    }

    @PostMapping("/login")
    public ResponseEntity <String> comprobarLogin(@Valid @RequestBody LoginUsuario loginUsuario) {
        if (usuarioService.comprobarLogin(loginUsuario)) {
            return ResponseEntity.ok("Login válido");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login inválido");
        }
    }

    @GetMapping("/byNickname/{nickname}")
    public ResponseEntity<UsuarioInfo> getUsuarioInfo(@PathVariable String nickname) {
        Optional<UsuarioInfo> usuarioInfo = usuarioService.getsByNickname(nickname);
        return usuarioInfo.map(ResponseEntity::ok).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    
    
}
