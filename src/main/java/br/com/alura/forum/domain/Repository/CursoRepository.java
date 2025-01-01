package br.com.alura.forum.domain.Repository;

import br.com.alura.forum.domain.Entities.curso.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    //Procura nome ignorando formatação
    Curso findByNomeIgnoreCase(String nome);
}
