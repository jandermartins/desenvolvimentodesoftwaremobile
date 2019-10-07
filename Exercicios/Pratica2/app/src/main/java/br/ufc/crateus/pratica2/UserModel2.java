package br.ufc.crateus.pratica2;

public class UserModel2 {
    String name;
    String email;
    String profissao;
    String username;
    String data;

    public UserModel2(String nome, String email, String profissao, String username, String data) {
        this.name = nome;
        this.email = email;
        this.profissao = profissao;
        this.username = username;
        this.data = data;
    }

    public UserModel2(String nome, String email) {
        this.name = nome;
        this.email = email;
    }

    public String getNome() {
        return name;
    }

    public void setNome(String nome) {
        this.name = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
