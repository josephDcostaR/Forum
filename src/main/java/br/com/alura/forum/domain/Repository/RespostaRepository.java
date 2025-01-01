package br.com.alura.forum.domain.Repository;

import br.com.alura.forum.domain.Entities.resposta.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespostaRepository extends JpaRepository<Resposta, Long> {
}
