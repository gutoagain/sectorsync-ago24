package com.manager.sectorsync.usuario.application.service;

import com.manager.sectorsync.usuario.application.api.UsuarioCriadoResponse;
import com.manager.sectorsync.usuario.application.api.UsuarioNovoRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class UsuarioApplicationService implements UsuarioService {
    @Override
    public UsuarioCriadoResponse criaNovoUsuario(UsuarioNovoRequest usuarioNovo) {
        log.info("[inicia] UsuarioApplicationService - criaNovoUsuario");
        log.info("[finaliza] UsuarioApplicationService - criaNovoUsuario");
        return null;
    }
}
