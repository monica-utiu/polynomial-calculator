package model;

import java.util.Collections;
import java.util.Comparator;

public class Operations {

    public Polynom add(Polynom p1, Polynom p2)
    {
        Polynom res = new Polynom();
        for(Monom monom:p1.getBody())
        {
            Monom pair = p2.getBody().stream().filter(m->m.getPow()==monom.getPow()).findFirst().orElse(null);
            if(pair!=null)
            {
                int coef = monom.getCoef() + pair.getCoef();
                Monom resMonom = new Monom(monom.getPow(),coef);
                res.getBody().add(resMonom);
                p2.getBody().remove(pair);
            }
            else
            {
                res.getBody().add(monom);
            }
        }
        // if still smth in p2
        for(Monom monom:p2.getBody())
        {
            res.getBody().add(monom);
        }
        res = sortPolynom(res);

        return res;
    }

    public Polynom subtract(Polynom p1,Polynom p2) {
        Polynom res = new Polynom();
        for(Monom monom:p1.getBody())
        {
            Monom pair = p2.getBody().stream().filter(m->m.getPow()==monom.getPow()).findFirst().orElse(null);
            if(pair!=null)
            {
                int coef = monom.getCoef() - pair.getCoef();
                Monom resMonom = new Monom(monom.getPow(),coef);
                res.getBody().add(resMonom);
                p2.getBody().remove(pair);
            }
            else
            {
                monom.setCoef(-1*monom.getCoef());
                res.getBody().add(monom);
            }
        }
        // if still smth in p2
        for(Monom monom:p2.getBody())
        {
            monom.setCoef(-1*monom.getCoef());
            res.getBody().add(monom);
        }
        res = sortPolynom(res);

        return res;
    }

    public Polynom multiply(Polynom p1, Polynom p2) {
        Polynom res= new Polynom();
        for(Monom monom1 : p1.getBody())
        {
            for(Monom monom2 : p2.getBody()) {
                Monom resMonom = new Monom(monom1.getCoef()* monom2.getCoef(),monom1.getPow()+ monom2.getPow());
                Monom pair = res.getBody().stream().filter(m -> m.getPow() == resMonom.getPow()).findFirst().orElse(null);
                if(pair!=null) {
                    pair.setCoef(pair.getCoef()+resMonom.getCoef());
                } else {
                    res.getBody().add(resMonom);
                }
            }
        }
        res=sortPolynom(res);
        return res;
    }

    public DivisionRes divide(Polynom p1, Polynom p2) {
        Polynom quotient = new Polynom();
        if(p1.getBody().get(0).getPow() < p2.getBody().get(0).getPow()) {
            Polynom aux = p1;
            p1=p2;
            p2=aux;
        }
        while(p1.getBody().get(0).getPow() >= p2.getBody().get(0).getPow()) {
            int pow = p1.getBody().get(0).getPow() - p2.getBody().get(0).getPow();
            int coef = p1.getBody().get(0).getCoef() / p2.getBody().get(0).getCoef();
            Monom monom = new Monom(coef,pow);
            Polynom dev = new Polynom();
            quotient.getBody().add(monom);
            dev.getBody().add(monom);   // the temp result of division
            dev = multiply(dev,p2);     // multiply it with divisor
            p1 = subtract(p1,dev);      // subtract the result
        }
        quotient = sortPolynom(quotient);
        p1 = sortPolynom(p1);
        return new DivisionRes(quotient,p1);
    }

    public Polynom derivation(Polynom p) {
        Polynom res = new Polynom();
        for(Monom monom : p.getBody()) {
            Monom resMonom = new Monom( monom.getCoef()* monom.getPow(),monom.getPow() - 1);
            if(resMonom.getCoef() != 0) {
                res.getBody().add(resMonom);
            }
        }
        res = sortPolynom(res);
        return res;
    }

    public Polynom integrate(Polynom p) {
        Polynom res = new Polynom();
        for(Monom monom : p.getBody()) {
            Monom resMonom;
            if(monom.getPow() != 0) {
                resMonom = new Monom(monom.getCoef()/ (monom.getPow()+1),monom.getPow()+1 );
            } else {
                resMonom = new Monom(monom.getCoef(),monom.getPow()+1);
            }
        }
        res = sortPolynom(res);
        return res;
    }

    public Polynom sortPolynom(Polynom p) {
        Collections.sort(p.getBody(), new Comparator<Monom>() {
            @Override
            public int compare(Monom o1, Monom o2) {
                if(o1.getPow() == o2.getPow()) return 0;
                return o1.getPow() > o2.getPow() ? -1 : 1;
            }
        });
        return p;
    }

    public Boolean comparePolynom(Polynom p1, Polynom p2) {
        p1 = this.sortPolynom(p1);
        p2 = this.sortPolynom(p2);
        if( p1.getBody().size() != p2.getBody().size() ) {
            return false;
        } else {
            for( Monom monom:p1.getBody() ) {
                Monom pair = p2.getBody().stream().filter(m -> m.getPow() == monom.getPow()).findFirst().orElse(null);
                if( pair==null ) {
                    return true;
                } else {
                    if( monom.getCoef() != pair.getCoef() ) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
