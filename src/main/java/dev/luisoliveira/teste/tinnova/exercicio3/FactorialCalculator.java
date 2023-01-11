package dev.luisoliveira.teste.tinnova.exercicio3;

public class FactorialCalculator {

    private int num;

    public FactorialCalculator() { }

    public FactorialCalculator(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public long calculateFactorial(){
        int num = this.getNum();
        long factorial = 1;

        for(int i = 1; i <= num; ++i){
            factorial *= i;
        }

        return factorial;
    }

}
