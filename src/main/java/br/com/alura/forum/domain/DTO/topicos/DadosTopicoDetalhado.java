package br.com.alura.forum.domain.DTO.topicos;

import br.com.alura.forum.domain.DTO.resposta.DadosRespostaResponse;
import br.com.alura.forum.domain.Enums.StatusTopico;
import br.com.alura.forum.domain.Entities.topicos.Topico;

import java.util.List;


public record DadosTopicoDetalhado(
        Long id,
        String titulo,
        String mensagem,
        String nomeAutor,
        StatusTopico status,
        List<DadosRespostaResponse> respostas
) {
    public DadosTopicoDetalhado(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getAutor() == null ? null : topico.getAutor().getNome(),
                topico.getStatus(),
                topico.getRespostas()
        );
    }
}