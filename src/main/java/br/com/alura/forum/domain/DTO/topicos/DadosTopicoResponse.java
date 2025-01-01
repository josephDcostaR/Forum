package br.com.alura.forum.domain.DTO.topicos;

import br.com.alura.forum.domain.Entities.topicos.Topico;

import java.time.LocalDateTime;

public record DadosTopicoResponse(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao
) {
    public DadosTopicoResponse(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao());
    }
}
