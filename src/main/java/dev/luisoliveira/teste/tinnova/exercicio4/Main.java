package dev.luisoliveira.teste.tinnova.exercicio4;

public class Main {

    public static void main(String[] args){

        SumMultiplesOfThreeAndFive sumMultiplesOfThreeAndFive = new SumMultiplesOfThreeAndFive();
        sumMultiplesOfThreeAndFive.setSumMultipleOfThreeAndFiveUntilThisNumber(10);

        System.out.printf("Soma dos numeros múltiplos de 3 e 5 até %d : %d",
                sumMultiplesOfThreeAndFive.getSumMultipleOfThreeAndFiveUntilThisNumber(),
                sumMultiplesOfThreeAndFive.calculate());
    }

}

