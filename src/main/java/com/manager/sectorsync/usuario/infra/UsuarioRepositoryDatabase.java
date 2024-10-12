package com.manager.sectorsync.usuario.infra;

import com.manager.sectorsync.usuario.application.repository.UsuarioRepository;
import com.manager.sectorsync.usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

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
}
