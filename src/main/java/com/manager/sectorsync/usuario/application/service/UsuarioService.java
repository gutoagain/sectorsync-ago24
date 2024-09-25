package com.manager.sectorsync.usuario.application.service;

import com.manager.sectorsync.usuario.application.api.UsuarioCriadoResponse;
import com.manager.sectorsync.usuario.application.api.UsuarioNovoRequest;

public interface UsuarioService {
    UsuarioCriadoResponse criaNovoUsuario(UsuarioNovoRequest usuarioNovo);
}
