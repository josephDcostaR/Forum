package br.com.alura.forum.infra.validacao_topico.atualizacao;


import br.com.alura.forum.domain.DTO.topicos.DadosTopicoAtualizacao;
import br.com.alura.forum.infra.exception.ValidacaoException;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoDeCampo implements ValidacaoAtualizacaoTopico{
    @Override
    public void validar(Long id, DadosTopicoAtualizacao dados) {
        if( dados.titulo() == null && dados.mensagem() == null){
            throw new ValidacaoException("É necessário informar ao menos um campo para atualização");
        }
    }
}