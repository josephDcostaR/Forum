package br.com.alura.forum.domain.DTO.usuario;


import br.com.alura.forum.domain.Entities.usuario.Usuario;

public record DadosNome(String nome) {

    public DadosNome(Usuario usuario) {
        this(usuario.getNome());
    }
}