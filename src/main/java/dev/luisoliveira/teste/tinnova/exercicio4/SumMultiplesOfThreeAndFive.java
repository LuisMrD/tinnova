package dev.luisoliveira.teste.tinnova.exercicio4;

public class SumMultiplesOfThreeAndFive {

    long sumMultipleOfThreeAndFiveUntilThisNumber;

    public SumMultiplesOfThreeAndFive() { }

    public SumMultiplesOfThreeAndFive(long sumMultipleOfThreeAndFiveUntilThisNumber) {
        this.sumMultipleOfThreeAndFiveUntilThisNumber = sumMultipleOfThreeAndFiveUntilThisNumber;
    }

    public long getSumMultipleOfThreeAndFiveUntilThisNumber() {
        return sumMultipleOfThreeAndFiveUntilThisNumber;
    }

    public void setSumMultipleOfThreeAndFiveUntilThisNumber(long sumMultipleOfThreeAndFiveUntilThisNumber) {
        this.sumMultipleOfThreeAndFiveUntilThisNumber = sumMultipleOfThreeAndFiveUntilThisNumber;
    }

    public long calculate(){
        long n = this.getSumMultipleOfThreeAndFiveUntilThisNumber();
        long sum = 0;

        for(int i = 0; i < n ; i++){
            if(i % 3 == 0 || i % 5 == 0){
                sum += i;
            }
        }

        return sum;
    }

}
