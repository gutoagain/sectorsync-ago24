package com.manager.sectorsync.usuario.application.service;

import com.manager.sectorsync.usuario.application.api.UsuarioCriadoResponse;
import com.manager.sectorsync.usuario.application.api.UsuarioEditaRequest;
import com.manager.sectorsync.usuario.application.api.UsuarioNovoRequest;

import java.util.UUID;

public interface UsuarioService {
    UsuarioCriadoResponse criaNovoUsuario(UsuarioNovoRequest usuarioNovo);
    UsuarioCriadoResponse buscaUsuarioPorId(UUID idUsuario);
    void editaUsuario(UUID idUsuario, UsuarioEditaRequest usuarioEditaRequest);
}
