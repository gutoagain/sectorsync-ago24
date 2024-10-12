package com.manager.sectorsync.usuario.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/public/v1/usuario")
public interface UsuarioAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    UsuarioCriadoResponse postNovoUsuario(@RequestBody @Valid UsuarioNovoRequest usuarioNovo);

    @GetMapping(value = "/{idUsuario}")
    @ResponseStatus(code = HttpStatus.OK)
    UsuarioCriadoResponse buscaUsuarioPorId(@PathVariable UUID idUsuario);

}
