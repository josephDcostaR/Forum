package br.com.alura.forum.domain.DTO.usuario;


public record DadosUsuarioAtualizacao(
        String nome,
        String senha
) {
    public DadosUsuarioAtualizacao atualizarSenha(String s) {
        return new DadosUsuarioAtualizacao(this.nome, s);
    }
}