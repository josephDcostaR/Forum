package br.com.alura.forum.domain.Repository;

import br.com.alura.forum.domain.Entities.usuario.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByEmail(String email);

    //Procurar todos os usuarios ativos
    Page<Usuario> findByAtivoTrue(Pageable paginacao);
}
