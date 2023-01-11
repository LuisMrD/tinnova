package dev.luisoliveira.teste.tinnova.exercicio2;

public class Main {

    public static void main(String[] args){

        int[] vectorToOrganize = {5, 3, 2, 4, 7, 1, 0, 6};

        BubbleSort bubbleSort = new BubbleSort();

        bubbleSort.bubbleSort(vectorToOrganize);
        bubbleSort.printArray(vectorToOrganize);

    }

}

