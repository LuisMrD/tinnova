package dev.luisoliveira.teste.tinnova.exercicio1;

public class VoteCalculator {

    private double totalOfVotes;
    private double validVotes;
    private double blankVotes;
    private double nullVotes;

    public VoteCalculator() { }

    public VoteCalculator(double totalOfVotes, double validVotes, double blankVotes, double nullVotes) {
        this.totalOfVotes = totalOfVotes;
        this.validVotes = validVotes;
        this.blankVotes = blankVotes;
        this.nullVotes = nullVotes;
    }

    public double getTotalOfVotes() {
        return totalOfVotes;
    }

    public void setTotalOfVotes(double totalOfVotes) {
        this.totalOfVotes = totalOfVotes;
    }

    public double getValidVotes() {
        return validVotes;
    }

    public void setValidVotes(double validVotes) {
        this.validVotes = validVotes;
    }

    public double getBlankVotes() {
        return blankVotes;
    }

    public void setBlankVotes(double blankVotes) {
        this.blankVotes = blankVotes;
    }

    public double getNullVotes() {
        return nullVotes;
    }

    public void setNullVotes(double nullVotes) {
        this.nullVotes = nullVotes;
    }

    public double calculatePercentageOf(double typeVoteToCompare){
        return (typeVoteToCompare * 100 ) / this.getTotalOfVotes();
    }

}
