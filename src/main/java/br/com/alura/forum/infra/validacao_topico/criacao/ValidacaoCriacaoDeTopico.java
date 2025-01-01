package br.com.alura.forum.infra.validacao_topico.criacao;

import br.com.alura.forum.domain.DTO.topicos.DadosTopicoCadastro;

public interface ValidacaoCriacaoDeTopico {

    void validar(DadosTopicoCadastro dados);
}
