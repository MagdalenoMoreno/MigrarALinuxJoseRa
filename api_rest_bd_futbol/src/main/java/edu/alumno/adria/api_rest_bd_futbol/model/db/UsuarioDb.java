package edu.alumno.adria.api_rest_bd_futbol.model.db;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "usuarios")
public class UsuarioDb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nombre;
    @NotNull
    @Column(unique = true)
    private String nickname;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(name = "idUsuario"), inverseJoinColumns = @JoinColumn(name = "idRol")) 
    private Set<RolDb> roles = new HashSet<>();

    public UsuarioDb(@NotNull String nombre, @NotNull String nickname, @NotNull String email, @NotNull String password) {
        this.nombre = nombre;
        this.nickname = nickname;
        this.email = email;
        this.password = password;

    }
}
