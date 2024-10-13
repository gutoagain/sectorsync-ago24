package com.manager.sectorsync.usuario.application.api;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class UsuarioEditaRequest {
    @NotBlank
    private String nome;
    @Email
    private String email;
}
