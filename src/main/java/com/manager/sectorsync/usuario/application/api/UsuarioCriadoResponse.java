package com.manager.sectorsync.usuario.application.api;

import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.UUID;

@Value
@RequiredArgsConstructor
public class UsuarioCriadoResponse {
    private final UUID idUsuario;
    private final String email;
}
