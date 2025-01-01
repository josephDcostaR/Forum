package br.com.alura.forum.infra.validacao_topico.atualizacao;

import br.com.alura.forum.domain.DTO.topicos.DadosTopicoAtualizacao;
import br.com.alura.forum.domain.Repository.TopicoRepository;
import br.com.alura.forum.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoDeExistenciaTopico implements ValidacaoAtualizacaoTopico{

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validar(Long id, DadosTopicoAtualizacao dados) {
        var topico = topicoRepository.findById(id);

        if(topico.isEmpty()) {
            throw new ValidacaoException("Informe um ID do topico valido.");
        }
    }
}