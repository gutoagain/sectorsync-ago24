package com.manager.sectorsync.usuario.application.service;

import com.manager.sectorsync.handler.APIException;
import com.manager.sectorsync.usuario.application.api.UsuarioCriadoResponse;
import com.manager.sectorsync.usuario.application.api.UsuarioNovoRequest;
import com.manager.sectorsync.usuario.application.repository.UsuarioRepository;
import com.manager.sectorsync.usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

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

    private void verificaSeUsuarioExiste(UsuarioNovoRequest usuarioNovo) {
        log.info("[inicia] UsuarioApplicationService - verificaSeUsuarioExiste");
        boolean usuarioExiste = usuarioRepository.verificaSeUsuarioExistePorEmail(usuarioNovo.getEmail());
        if (usuarioExiste) {
            throw APIException.build(HttpStatus.UNAUTHORIZED, "Email já existe.");
        }
        log.info("[finaliza] UsuarioApplicationService - verificaSeUsuarioExiste");
    }
}
