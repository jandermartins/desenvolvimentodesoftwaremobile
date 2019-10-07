package br.ufc.crateus.pratica2;

public class Model {
    String name;
    String email;

    public Model(String nome, String email) {
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

    @Override
    public String toString() {
        return "Model{" +
                "nome='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
