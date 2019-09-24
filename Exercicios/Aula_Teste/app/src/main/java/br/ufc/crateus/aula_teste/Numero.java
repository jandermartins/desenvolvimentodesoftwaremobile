package br.ufc.crateus.aula_teste;

public class Numero {

    private int num;

    @Override
    public String toString() {
        return "Numero{" +
                "num=" + num +
                '}';
    }

    public Numero(int num) {
        this.num = num;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
