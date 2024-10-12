package com.manager.sectorsync.usuario.application.api;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor(force = true)
public class UsuarioNovoRequest {
    @Email
    private final String email;
    @Size(min = 6)
    private final String senha;
}
