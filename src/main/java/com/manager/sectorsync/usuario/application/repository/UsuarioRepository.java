package com.manager.sectorsync.usuario.application.repository;

import com.manager.sectorsync.usuario.domain.Usuario;

public interface UsuarioRepository {
    Usuario salva(Usuario usuario);
    boolean verificaSeUsuarioExistePorEmail(String email);
}
