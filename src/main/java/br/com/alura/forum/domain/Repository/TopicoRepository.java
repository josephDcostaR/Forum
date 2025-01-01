package br.com.alura.forum.domain.Repository;

import br.com.alura.forum.domain.Entities.topicos.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    //Procurar topico por título e mensagem ignorando formatação
    Topico findByTituloAndMensagemIgnoreCase(String titulo, String mensagem);

    //Procurar todos os topicos
    Page<Topico> findAll(Pageable paginacao);

    //Procurar autor do topico
    Page<Topico> findByAutorId(Long id, Pageable paginacao);

}
