package dev.luisoliveira.teste.tinnova.exercicio3;

public class Main {

    public static void main(String[] args){

        FactorialCalculator factorialCalculator = new FactorialCalculator();
        factorialCalculator.setNum(5);

        System.out.printf("Fatorial de %d = %d", factorialCalculator.getNum(), factorialCalculator.calculateFactorial());

    }

}
