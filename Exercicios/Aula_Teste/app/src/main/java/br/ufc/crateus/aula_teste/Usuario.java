package br.ufc.crateus.aula_teste;

public class Usuario {

    private int id;
    private String nome;
    private String email;
    private String username;
    private String profissao;
    private String data;

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", profissao='" + profissao + '\'' +
                ", data='" + data + '\'' +
                '}';
    }

    public Usuario(int id, String nome, String email, String username, String profissao, String data) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.username = username;
        this.profissao = profissao;
        this.data = data;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
