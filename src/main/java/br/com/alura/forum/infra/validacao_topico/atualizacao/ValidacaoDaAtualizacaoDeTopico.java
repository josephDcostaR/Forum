package br.com.alura.forum.infra.validacao_topico.atualizacao;

import br.com.alura.forum.domain.DTO.topicos.DadosTopicoAtualizacao;
import br.com.alura.forum.domain.Repository.TopicoRepository;
import br.com.alura.forum.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoDaAtualizacaoDeTopico implements ValidacaoAtualizacaoTopico {

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validar(Long id, DadosTopicoAtualizacao dados) {
        var topico = topicoRepository.findByTituloAndMensagemIgnoreCase(dados.titulo(), dados.mensagem());

        if(topico != null) {
            throw new ValidacaoException("Já existe um tópico com o mesmo título e mensagem");
        }
    }
}