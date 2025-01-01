package br.com.alura.forum.domain.DTO.usuario;

import jakarta.validation.constraints.NotBlank;

public record DadosAutenticacao(
        @NotBlank  String email,
        @NotBlank String senha) {
}