package com.manager.sectorsync.usuario.infra;

import com.manager.sectorsync.handler.APIException;
import com.manager.sectorsync.usuario.application.repository.UsuarioRepository;
import com.manager.sectorsync.usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
@Log4j2
public class UsuarioRepositoryDatabase implements UsuarioRepository {
    private final UsuarioPostgreSqlRepository usuarioPostgreSqlRepository;

    @Override
    public Usuario salva(Usuario usuario) {
        log.info("[inicia] UsuarioRepositoryDatabase - salva");
        Usuario novoUsuario = usuarioPostgreSqlRepository.save(usuario);
        log.info("[finaliza] UsuarioRepositoryDatabase - salva");
        return novoUsuario;
    }

    @Override
    public boolean verificaSeUsuarioExistePorEmail(String email) {
        log.info("[inicia] UsuarioRepositoryDatabase - verificaSeUsuarioExistePorEmail");
        Usuario usuario = usuarioPostgreSqlRepository.findByEmail(email);
        log.info("[finaliza] UsuarioRepositoryDatabase - verificaSeUsuarioExistePorEmail");
        return usuario != null;
    }

    @Override
    public Usuario buscaUsuarioPorId(UUID idUsuario) {
        log.info("[inicia] UsuarioRepositoryDatabase - buscaUsuarioPorId");
        Usuario usuario = usuarioPostgreSqlRepository.findByIdUsuario(idUsuario)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Usuario não encontrado!"));
        log.info("[finaliza] UsuarioRepositoryDatabase - buscaUsuarioPorId");
        return usuario;
    }

    @Override
    public void detelaUsuario(Usuario usuario) {
        log.info("[inicia] UsuarioRepositoryDatabase - detelaUsuario");
        usuarioPostgreSqlRepository.delete(usuario);
        log.info("[finaliza] UsuarioRepositoryDatabase - detelaUsuario");
    }
}
