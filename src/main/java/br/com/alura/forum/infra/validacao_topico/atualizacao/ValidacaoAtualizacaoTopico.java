package br.com.alura.forum.infra.validacao_topico.atualizacao;

import br.com.alura.forum.domain.DTO.topicos.DadosTopicoAtualizacao;

public interface ValidacaoAtualizacaoTopico {

    void validar(Long id, DadosTopicoAtualizacao dados);
}
