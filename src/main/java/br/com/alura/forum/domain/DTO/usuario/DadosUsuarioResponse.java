package br.com.alura.forum.domain.DTO.usuario;

import br.com.alura.forum.domain.Entities.usuario.Usuario;

public record DadosUsuarioResponse(
        Long id,
        String nome,
        String email
) {
    public DadosUsuarioResponse(Usuario novoUsuario) {
        this(novoUsuario.getId(), novoUsuario.getNome(), novoUsuario.getEmail());
    }
}