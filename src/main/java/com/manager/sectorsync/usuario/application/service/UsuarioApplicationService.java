package com.manager.sectorsync.usuario.application.service;

import com.manager.sectorsync.handler.APIException;
import com.manager.sectorsync.usuario.application.api.UsuarioCriadoResponse;
import com.manager.sectorsync.usuario.application.api.UsuarioEditaRequest;
import com.manager.sectorsync.usuario.application.api.UsuarioNovoRequest;
import com.manager.sectorsync.usuario.application.repository.UsuarioRepository;
import com.manager.sectorsync.usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class UsuarioApplicationService implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Override
    public UsuarioCriadoResponse criaNovoUsuario(UsuarioNovoRequest usuarioNovo) {
        log.info("[inicia] UsuarioApplicationService - criaNovoUsuario");
        verificaSeUsuarioExiste(usuarioNovo);
        Usuario usuario = new Usuario(usuarioNovo);
        usuarioRepository.salva(usuario);
        log.info("[finaliza] UsuarioApplicationService - criaNovoUsuario");
        return new UsuarioCriadoResponse(usuario);
    }

    @Override
    public UsuarioCriadoResponse buscaUsuarioPorId(UUID idUsuario) {
        log.info("[inicia] UsuarioApplicationService - buscaUsuarioPorId");
        Usuario usuario = usuarioRepository.buscaUsuarioPorId(idUsuario);
        log.info("[finaliza] UsuarioApplicationService - buscaUsuarioPorId");
        return new UsuarioCriadoResponse(usuario);
    }

    @Override
    public void editaUsuario(UUID idUsuario, UsuarioEditaRequest usuarioEditaRequest) {
        log.info("[inicia] UsuarioApplicationService - editaUsuario");
        Usuario usuario = usuarioRepository.buscaUsuarioPorId(idUsuario);
        usuario.editaUsuario(usuarioEditaRequest);
        usuarioRepository.salva(usuario);
        log.info("[finaliza] UsuarioApplicationService - editaUsuario");
    }

    @Override
    public void deletaUsuario(UUID idUsuario) {
        log.info("[inicia] UsuarioApplicationService - deletaUsuario");
        log.info("[finaliza] UsuarioApplicationService - deletaUsuario");
    }

    private void verificaSeUsuarioExiste(UsuarioNovoRequest usuarioNovo) {
        log.info("[inicia] UsuarioApplicationService - verificaSeUsuarioExiste");
        boolean usuarioExiste = usuarioRepository.verificaSeUsuarioExistePorEmail(usuarioNovo.getEmail());
        if (usuarioExiste) {
            throw APIException.build(HttpStatus.UNAUTHORIZED, "Email já existe.");
        }
        log.info("[finaliza] UsuarioApplicationService - verificaSeUsuarioExiste");
    }
}
