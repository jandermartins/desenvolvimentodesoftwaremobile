package br.ufc.crateus.bancodedados.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Usuario {
    @PrimaryKey(autoGenerate = true)
    private Integer id;
    @ColumnInfo(name = "primeiro_nome")
    private String primeiroNome;
    @ColumnInfo(name = "segundo_nome")
    private String segundoNome;

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    @ColumnInfo(name = "idade")
    private Integer idade;


    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", primeiroNome='" + primeiroNome + '\'' +
                ", segundoNome='" + segundoNome + '\'' +
                ", idade=" + idade +
                '}';
    }

    public Usuario(String primeiroNome, String segundoNome, Integer idade) {
        this.primeiroNome = primeiroNome;
        this.segundoNome = segundoNome;
        this.idade = idade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getSegundoNome() {
        return segundoNome;
    }

    public void setSegundoNome(String segundoNome) {
        this.segundoNome = segundoNome;
    }
}
