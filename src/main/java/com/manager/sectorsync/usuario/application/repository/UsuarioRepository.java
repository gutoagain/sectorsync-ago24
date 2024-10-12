package com.manager.sectorsync.usuario.application.repository;

import com.manager.sectorsync.usuario.domain.Usuario;

import java.util.UUID;

public interface UsuarioRepository {
    Usuario salva(Usuario usuario);
    boolean verificaSeUsuarioExistePorEmail(String email);
    Usuario buscaUsuarioPorId(UUID idUsuario);
}
