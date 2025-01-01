package br.com.alura.forum.infra.validacao_topico.criacao;

import br.com.alura.forum.domain.DTO.topicos.DadosTopicoCadastro;
import br.com.alura.forum.domain.Entities.topicos.Topico;
import br.com.alura.forum.domain.Repository.TopicoRepository;
import br.com.alura.forum.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidacaoDeTopico implements ValidacaoCriacaoDeTopico{

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validar(DadosTopicoCadastro dados) {

        Topico topico = topicoRepository.findByTituloAndMensagemIgnoreCase(dados.titulo(), dados.mensagem());

        if (topico != null){
            throw new ValidacaoException("Tópico já existente: " + dados.titulo());
        }

    }
}
