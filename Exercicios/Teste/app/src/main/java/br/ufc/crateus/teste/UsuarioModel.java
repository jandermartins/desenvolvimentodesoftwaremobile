package br.ufc.crateus.teste;

public class UsuarioModel {

    private String nome;
    private String email;
    private String login;
    private String senha;

    public UsuarioModel() {

    }

    @Override
    public String toString() {
        return "UsuarioModel{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
