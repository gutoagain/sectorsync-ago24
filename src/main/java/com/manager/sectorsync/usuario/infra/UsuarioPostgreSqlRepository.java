package com.manager.sectorsync.usuario.infra;

import com.manager.sectorsync.usuario.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioPostgreSqlRepository extends JpaRepository<Usuario, UUID> {
    Usuario findByEmail(String email);
    Optional<Usuario> findByIdUsuario(UUID idUsuario);
}
