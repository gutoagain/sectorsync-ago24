package com.manager.sectorsync.usuario.application.api;

import com.manager.sectorsync.usuario.application.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Validated
@Log4j2
@RequiredArgsConstructor
public class UsuarioController implements UsuarioAPI {
    private final UsuarioService usuarioAppplicationService;

    @Override
    public UsuarioCriadoResponse postNovoUsuario(UsuarioNovoRequest usuarioNovo) {
        log.info("[inicia] UsuarioController - postNovoUsuario");
        UsuarioCriadoResponse usuarioCriado = usuarioAppplicationService.criaNovoUsuario(usuarioNovo);
        log.info("[finaliza] UsuarioController - postNovoUsuario");
        return usuarioCriado;
    }

    @Override
    public UsuarioCriadoResponse buscaUsuarioPorId(UUID idUsuario) {
        log.info("[inicia] UsuarioController - buscaUsuarioPorId");
        log.info("[idUsuario] {}", idUsuario);
        UsuarioCriadoResponse buscaUsuario = usuarioAppplicationService.buscaUsuarioPorId(idUsuario);
        log.info("[finaliza] UsuarioController - buscaUsuarioPorId");
        return buscaUsuario;
    }

    @Override
    public void editaUsuario(UUID idUsuario, UsuarioEditaRequest usuarioEditaRequest) {
        log.info("[inicia] UsuarioController - editaUsuario");
        usuarioAppplicationService.editaUsuario(idUsuario, usuarioEditaRequest);
        log.info("[finaliza] UsuarioController - editaUsuario");
    }
}
