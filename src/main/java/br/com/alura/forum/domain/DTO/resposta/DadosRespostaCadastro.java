package br.com.alura.forum.domain.DTO.resposta;

import jakarta.validation.constraints.NotBlank;

public record DadosRespostaCadastro(
        @NotBlank String mensagem,
        @NotBlank String solucao
) {
}