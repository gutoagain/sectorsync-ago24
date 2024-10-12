package com.manager.sectorsync.usuario.domain;

import com.manager.sectorsync.handler.APIException;
import com.manager.sectorsync.usuario.application.api.UsuarioNovoRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;

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
    @NotEmpty(message = "O campo email é obrigatório.")
    @Size(min = 5, max = 255, message = "O email deve ter entre 5 e 255 caracteres.")
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

    public void validaSeUsuarioExistePorEmail(String usuarioEmail) {
        log.info("[inicia] Usuario - validaSeUsuarioNaoExistePorEmail");
        if (this.email.equals(usuarioEmail)) {
            log.info("[finaliza] APIException - validaUsuario");
            throw APIException.build(HttpStatus.UNAUTHORIZED, "Email já existe.");
        }
        log.info("[finaliza] Usuario - validaSeUsuarioNaoExistePorEmail");
    }
}
