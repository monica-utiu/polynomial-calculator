package model;

import exceptions.InvalidPolynomException;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynom {
    ArrayList<Monom> body;

    public Polynom(){
        this.body = new ArrayList<>();
    }

    public Polynom(ArrayList<Monom> body) {
        this.body = body;
    }

    public ArrayList<Monom> getBody() {
        return body;
    }

    public void setBody(ArrayList<Monom> body) {
        this.body = body;
    }

    public Polynom parsePolynom(String polynom) throws InvalidPolynomException {
        Polynom res = new Polynom();


        if(polynom == null) throw new InvalidPolynomException("Invalid format for polynom");
        Pattern patternp = Pattern.compile("([+-]?[^+-]+)");
        Matcher matcherp = patternp.matcher(polynom);


        while(matcherp.find()) {
            Pattern pattern = Pattern.compile("^([+-])?(([0-9]+)?([0-9]+\\.[0-9]+)?)(X(\\^([0-9]+))?)?$");
            Matcher matcher = pattern.matcher(matcherp.group(1));
            int parsedCoef=1,parsedPow=1;
            if(!matcher.matches()) continue;
            String sign = matcher.group(1);
            String coef = matcher.group(2);
            String pow = matcher.group(7);

            if(coef==null || coef.equals("")) {
                if(sign!=null && sign.equals("-")) parsedCoef=-1;
            }

            if( coef!=null && !coef.equals("")) {
                if (sign==null || sign.equals("+") || sign.equals("")) {
                    parsedCoef = Integer.parseInt(coef);
                } else {
                    if(sign.equals("-"))
                        parsedCoef = -1 * Integer.parseInt(coef);
                }
            }

            if(pow!=null && !pow.equals("") && matcher.group(5)!=null) {
                parsedPow = Integer.parseInt(pow);
            } else {
                if(matcher.group(5)==null || !matcher.group(5).contains("X")) parsedPow=0;
            }
            Monom monom = new Monom(parsedCoef,parsedPow);
            if(parsedCoef!=0) {
                Monom pair = res.getBody().stream().filter(m->m.getPow()==monom.getPow()).findFirst().orElse(null);
                if(pair==null) res.getBody().add(monom);
                else pair.setCoef(pair.getCoef() + monom.getCoef());
            }
        }
       // res = sortPolynom(res);
        System.out.println(res.toString());
        return res;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for(Monom monom:this.getBody()) {
            double coef= monom.getCoef();
            int pow=monom.getPow();
            if(coef > 0 && !output.toString().equals("")) {
                output.append("+");
            }
            if(coef!=0) {
                if(Math.ceil(coef) == coef) {
                    if(coef!=1) {
                        if(coef!= -1) {
                            output.append(coef);
                        } else {
                            output.append("-");
                        }
                    }
                } else {
                    output.append(coef);
                }
                if(pow!=0) {
                    output.append("X");
                    if(pow!=1) {
                        output.append("^");
                        output.append(pow);
                    }
                }
                else output.append(coef);
            }
        }
        if(output.toString().equals("")) return "0";
        else return output.toString();
    }
}
