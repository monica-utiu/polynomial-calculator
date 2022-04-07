package model;

public class DivisionRes {
    private Polynom quotient;
    private Polynom remainder;

    public DivisionRes(Polynom quotient, Polynom remainder) {
        this.quotient = quotient;
        this.remainder = remainder;
    }

    public Polynom getQuotient() {
        return quotient;
    }

    public void setQuotient(Polynom quotient) {
        this.quotient = quotient;
    }

    public Polynom getRemainder() {
        return remainder;
    }

    public void setRemainder(Polynom remainder) {
        this.remainder = remainder;
    }

    @Override
    public String toString() {
        String output="";
        output+=this.quotient.toString();
        output+="\n";
        output+=this.remainder.toString();
        return output;
    }
}
