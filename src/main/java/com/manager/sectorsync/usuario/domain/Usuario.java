package com.manager.sectorsync.usuario.domain;

import com.manager.sectorsync.usuario.application.api.UsuarioEditaRequest;
import com.manager.sectorsync.usuario.application.api.UsuarioNovoRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Log4j2
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "idUsuario", updatable = false, unique = true, nullable = false)
    private UUID idUsuario;
    @Size(min = 1, max = 60)
    private String nome;
    @Email
    @Column(unique = true, nullable = false)
    private String email;
    @Size(max = 60)
    private String senha;

    public Usuario(UsuarioNovoRequest usuarioNovo) {
        this.idUsuario = UUID.randomUUID();
        this.nome = usuarioNovo.getNome();
        this.email = usuarioNovo.getEmail();
        this.senha = usuarioNovo.getSenha();
    }

    public void editaUsuario(UsuarioEditaRequest usuarioEditaRequest) {
        // Nome
        if (usuarioEditaRequest.getNome() == null) {
            usuarioEditaRequest.setNome(this.nome);
        } else {
            this.nome = usuarioEditaRequest.getNome();
        }
        // Email
        if (usuarioEditaRequest.getEmail() == null) {
            usuarioEditaRequest.setEmail(this.email);
        } else {
            this.email = usuarioEditaRequest.getEmail();
        }
    }
}
