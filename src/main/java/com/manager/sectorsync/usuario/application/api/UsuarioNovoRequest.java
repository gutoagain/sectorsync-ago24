package com.manager.sectorsync.usuario.application.api;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor(force = true)
public class UsuarioNovoRequest {
    @NotBlank
    private final String nome;
    @Email
    @NotEmpty(message = "O campo email é obrigatório.")
    @Size(min = 5, max = 255, message = "O email deve ter entre 5 e 255 caracteres.")
    private final String email;
    @Size(min = 6)
    private final String senha;
}
