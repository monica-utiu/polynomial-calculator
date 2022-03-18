package model;

import static java.lang.Integer.parseInt;

public class Monom {
    private int pow;
    private double coef;

    public Monom() {

    }

    public Monom(double coef, int pow) {
        this.pow = pow;
        this.coef = coef;
    }

    public int getPow() {
        return pow;
    }

    public void setPow(int pow) {
        this.pow = pow;
    }

    public double getCoef() {
        return coef;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }

    public Monom add(Monom m1) {
        Monom res = new Monom();
        if(this.pow == m1.pow) {
            res.pow = this.pow;
            res.coef = this.coef+m1.coef;
        }
        else return null;
        return res;
    }

    public Monom multiply(Monom m1) {
        Monom res = new Monom();
        res.pow = this.pow*m1.pow;
        res.coef = this.coef*m1.coef;
        return res;
    }

    public Monom Monom(String s) {
        int i=s.indexOf('X');
        double coef;
        int pow;
        if(i==-1) {
          pow = 0;
          coef = parseInt(s);
        }else {
            coef = (i == 0) ? 0 : parseInt(s.substring(0, i));
            pow = (s.charAt(i + 1) == '^') ? parseInt(s.substring(i + 2)) : 1;
        }
        return new Monom(coef, pow);
    }

    @Override
    public String toString(){
        return this.coef + "X^" + pow;
    }

    public boolean equals(Monom l) {
        return this.coef == l.coef && this.pow == l.pow;
    }

    public Monom derivative() {
        return new Monom(this.coef*this.pow,this.pow-1);
    }

    public Monom integral() {
        return new Monom((int)(this.coef/(this.pow+1)),this.pow+1 );
    }

}
