package model;

import java.util.ArrayList;

public class Polynom {
    ArrayList<Monom> body;

    public Polynom(){
        this.body = new ArrayList<>();
        this.body.add(new Monom(0,0));
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
}
