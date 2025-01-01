package br.com.alura.forum.infra.validacao_topico.atualizacao;

import br.com.alura.forum.domain.DTO.topicos.DadosTopicoAtualizacao;
import br.com.alura.forum.domain.Entities.topicos.Topico;
import br.com.alura.forum.domain.Repository.TopicoRepository;
import br.com.alura.forum.infra.exception.ValidacaoException;
import br.com.alura.forum.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoUsuarioAtualizacao implements ValidacaoAtualizacaoTopico{

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void validar(Long id, DadosTopicoAtualizacao dados) {
        Topico topico = topicoRepository.findById(id).orElse(null);

        if(topico.getAutor() != usuarioService.usuarioAtual()) {
            throw new ValidacaoException("Usuario nao autorizado para atualizar o topico.");
        }
    }
}