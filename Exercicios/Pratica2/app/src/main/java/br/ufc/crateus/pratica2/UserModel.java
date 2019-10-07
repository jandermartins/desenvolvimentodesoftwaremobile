package br.ufc.crateus.pratica2;

public class UserModel {

    int num1;
    int num2;
    int num3;
    int numResult;

    public UserModel(int num1, int num2, int num3, int numResult) {
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
        this.numResult = numResult;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getNum3() {
        return num3;
    }

    public void setNum3(int num3) {
        this.num3 = num3;
    }

    public int getNumResult() {
        return numResult;
    }

    public void setNumResult(int numResult) {
        this.numResult = numResult;
    }
}
