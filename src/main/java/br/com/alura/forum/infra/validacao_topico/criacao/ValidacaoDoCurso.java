package br.com.alura.forum.infra.validacao_topico.criacao;

import br.com.alura.forum.domain.DTO.topicos.DadosTopicoCadastro;
import br.com.alura.forum.domain.Repository.CursoRepository;
import br.com.alura.forum.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoDoCurso implements ValidacaoCriacaoDeTopico {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public void validar(DadosTopicoCadastro dados) {
        var curso = cursoRepository.findByNomeIgnoreCase(dados.nomeCurso());
        if (curso == null) {
            throw new ValidacaoException("Curso não encontrado: " + dados.nomeCurso());
        }

    }
}