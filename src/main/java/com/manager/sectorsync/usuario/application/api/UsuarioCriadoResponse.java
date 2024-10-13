package com.manager.sectorsync.usuario.application.api;

import com.manager.sectorsync.usuario.domain.Usuario;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.UUID;

@Value
@RequiredArgsConstructor
@Builder
public class UsuarioCriadoResponse {
    private final UUID idUsuario;
    private final String nome;
    private final String email;

    public UsuarioCriadoResponse(Usuario usuario) {
        this.idUsuario = usuario.getIdUsuario();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
    }
}
