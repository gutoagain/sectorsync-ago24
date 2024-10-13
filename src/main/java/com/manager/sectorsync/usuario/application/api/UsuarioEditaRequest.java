package com.manager.sectorsync.usuario.application.api;

import jakarta.validation.constraints.Email;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class UsuarioEditaRequest {
    private String nome;
    @Email
    private String email;
}
