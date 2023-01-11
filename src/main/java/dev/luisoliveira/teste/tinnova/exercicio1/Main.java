package dev.luisoliveira.teste.tinnova.exercicio1;

public class Main {

    public static void main(String[] args){

        VoteCalculator voteCalculator = new VoteCalculator();
        voteCalculator.setTotalOfVotes(1000);
        voteCalculator.setValidVotes(800);
        voteCalculator.setBlankVotes(150);
        voteCalculator.setNullVotes(50);

        double validVotesInRelationToTotalVotes = voteCalculator.calculatePercentageOf(voteCalculator.getValidVotes());
        double blankVotesInRelationToTotalVotes = voteCalculator.calculatePercentageOf(voteCalculator.getBlankVotes());
        double nullVotesInRelationToTotalVotes = voteCalculator.calculatePercentageOf(voteCalculator.getNullVotes());

        System.out.printf("Porcentagem de votos válidos em relação ao total de votos : %.0f%% \n", validVotesInRelationToTotalVotes);
        System.out.printf("Porcentagem de votos  em branco em relação ao total de votos : %.0f%% \n", blankVotesInRelationToTotalVotes);
        System.out.printf("Porcentagem de votos  nulos em relação ao total de votos : %.0f%% \n", nullVotesInRelationToTotalVotes);

    }

}
