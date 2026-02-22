package com.treinamento.treino.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioDTO {

    private final Long id;

    @NotBlank(message = "O nome do usuário é obrigatório")
    @Size(min = 3, message = "O nome do usuário deve conter pelo menos 3 caracteres")
    private final String nome;

    public UsuarioDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
