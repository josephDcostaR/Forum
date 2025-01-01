package br.com.alura.forum.service;



import br.com.alura.forum.domain.DTO.topicos.DadosTopicoAtualizacao;
import br.com.alura.forum.domain.DTO.topicos.DadosTopicoCadastro;
import br.com.alura.forum.domain.DTO.topicos.DadosTopicoResponse;
import br.com.alura.forum.domain.Entities.curso.Curso;
import br.com.alura.forum.domain.Entities.topicos.Topico;
import br.com.alura.forum.domain.Entities.usuario.Usuario;
import br.com.alura.forum.domain.Enums.StatusTopico;
import br.com.alura.forum.domain.Repository.TopicoRepository;
import br.com.alura.forum.infra.exception.ValidacaoException;
import br.com.alura.forum.infra.validacao_topico.atualizacao.ValidacaoAtualizacaoTopico;
import br.com.alura.forum.infra.validacao_topico.criacao.ValidacaoCriacaoDeTopico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoService cursoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private List<ValidacaoCriacaoDeTopico> validacoesCriacao;

    @Autowired
    private List<ValidacaoAtualizacaoTopico> validacoesAtualizacao;

    @Transactional
    public DadosTopicoResponse criarTopico(DadosTopicoCadastro cadastro) {

        usuarioService.verificarSeUsuarioEstaAtivo();

        validacoesCriacao.forEach(validacao -> validacao.validar(cadastro));

        Curso curso = cursoService.buscarPorNome(cadastro.nomeCurso());

        Usuario autor = usuarioService.usuarioAtual();

        Topico topico = new Topico(cadastro, curso, autor);

        Topico newTopico = topicoRepository.save(topico);

        return parseDadosTopicoResponse(newTopico);
    }

    private DadosTopicoResponse parseDadosTopicoResponse(Topico topico) {
        return new DadosTopicoResponse(topico);
    }

    public Topico buscarPorTituloEMensagem(String titulo, String mensagem) {
        return topicoRepository.findByTituloAndMensagemIgnoreCase(titulo, mensagem);
    }

    public Page<Topico> buscarTodos(Pageable paginacao) {
        return topicoRepository.findAll(paginacao);
    }

    public Topico buscarPorId(Long id) {
        return topicoRepository.findById(id).orElse(null);
    }

    @Transactional
    public DadosTopicoResponse atualizarTopico(Long id, DadosTopicoAtualizacao atualizacao) {

        usuarioService.verificarSeUsuarioEstaAtivo();

        validacoesAtualizacao.forEach(validacao -> validacao.validar(id, atualizacao));

        Topico topico = topicoRepository.findById(id).orElse(null);
        topico.atualizar(atualizacao);

        return new DadosTopicoResponse(topico);
    }

    @Transactional
    public void removerTopico(Long id) {

        usuarioService.verificarSeUsuarioEstaAtivo();

        Topico topico = topicoRepository.findById(id).orElse(null);

        if (topico != null && topico.getAutor() != usuarioService.usuarioAtual()) {
            throw new ValidacaoException("Não foi possivel deletar o topico");
        }

        topicoRepository.deleteById(id);
    }

    @Transactional
    public void atualizarStatusTopico(Topico topico) {
        if (topico.getStatus().equals(StatusTopico.NAO_RESPONDIDO)) {
            topico.setStatus(StatusTopico.NAO_SOLUCIONADO);
            return;
        }
        if (topico.getStatus().equals(StatusTopico.NAO_SOLUCIONADO)) {
            topico.setStatus(StatusTopico.SOLUCIONADO);
        }
    }

    @Transactional
    public void decrementarStatus(Topico topico) {
        if(topico.getRespostas().size() == 1){
            topico.setStatus(StatusTopico.NAO_RESPONDIDO);
        }
    }
}