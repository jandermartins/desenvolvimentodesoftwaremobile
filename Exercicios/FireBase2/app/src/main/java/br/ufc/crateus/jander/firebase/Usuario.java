package br.ufc.crateus.jander.firebase;

public class Usuario {

    private String nome;
    private String login;
    private int age;

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", login='" + login + '\'' +
                ", age=" + age +
                '}';
    }

    public Usuario() {

    }

    public Usuario(String nome, String login, int age) {
        this.nome = nome;
        this.login = login;
        this.age = age;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
