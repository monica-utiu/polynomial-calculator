import exceptions.InvalidPolynomException;
import model.DivisionRes;
import org.junit.jupiter.api.Test;
import model.Monom;
import model.Operations;
import model.Polynom;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorTest {

    Operations model = new Operations();

    @Test
    public void test_addition() {
        Polynom p1 = new Polynom();
        p1.getBody().add(new Monom(1,2));
        p1.getBody().add(new Monom(7,1));

        Polynom p2 = new Polynom();
        p2.getBody().add(new Monom(3,1));
        p2.getBody().add(new Monom(5,3));
        p2.getBody().add(new Monom(23,0));

        Polynom sum = model.add(p1,p2);
        Polynom expected = new Polynom();

        expected.getBody().add(new Monom(5, 3));
        expected.getBody().add(new Monom(1, 2));
        expected.getBody().add(new Monom(10, 1));
        expected.getBody().add(new Monom(23, 0));
        assertTrue(model.comparePolynom(sum, expected));
       // assertEquals(sum,expected);
    }

    @Test
    public void test_subtraction() throws InvalidPolynomException {
        Polynom p1 = new Polynom();
        p1.getBody().add(new Monom(1,2));
        p1.getBody().add(new Monom(7,1));

        Polynom p2 = new Polynom();
        p2.getBody().add(new Monom(3,1));
        p2.getBody().add(new Monom(5,3));
        p2.getBody().add(new Monom(23,0));

        Polynom dif = model.subtract(p1,p2);
        Polynom expected = new Polynom();

        expected.getBody().add(new Monom(-5, 3));
        expected.getBody().add(new Monom(1, 2));
        expected.getBody().add(new Monom(4, 1));
        expected.getBody().add(new Monom(-23, 0));
        assertTrue(model.comparePolynom(dif, expected));
       // assertEquals(dif,expected);

    }

    @Test
    public void test_multiplication() throws InvalidPolynomException {
        Polynom p1 = new Polynom();
        p1.getBody().add(new Monom(1,2));
        p1.getBody().add(new Monom(7,1));

        Polynom p2 = new Polynom();
        p2.getBody().add(new Monom(3,1));
        p2.getBody().add(new Monom(5,3));
        p2.getBody().add(new Monom(23,0));

        Polynom product = model.multiply(p1,p2);
        Polynom expected = new Polynom();

        expected.getBody().add(new Monom(5, 5));
        expected.getBody().add(new Monom(35, 4));
        expected.getBody().add(new Monom(3, 3));
        expected.getBody().add(new Monom(44, 2));
        expected.getBody().add(new Monom(7*23, 1));
        assertTrue(model.comparePolynom(product, expected));
        //assertEquals(product,expected);
    }



    @Test
    public void test_derivation() throws InvalidPolynomException {
        Polynom p2 = new Polynom();
        p2.getBody().add(new Monom(3,1));
        p2.getBody().add(new Monom(5,3));
        p2.getBody().add(new Monom(23,0));

        Polynom derivative = model.derivation(p2);
        Polynom expected = new Polynom();

        expected.getBody().add(new Monom(15, 2));
        expected.getBody().add(new Monom(3, 0));

        assertTrue(model.comparePolynom(derivative, expected));
        //assertEquals(derivative,expected);
    }

    @Test
    public void test_integration() throws InvalidPolynomException {
        Polynom p2 = new Polynom();
        p2.getBody().add(new Monom(3,1));
        p2.getBody().add(new Monom(5,3));
        p2.getBody().add(new Monom(23,0));

        Polynom integral = model.integrate(p2);
        Polynom expected = new Polynom();

        expected.getBody().add(new Monom(5d/4, 4));
        expected.getBody().add(new Monom(3d/2, 2));
        expected.getBody().add(new Monom(23,1));

        assertTrue(model.comparePolynom(integral, expected));
        //assertEquals(integral,expected);
    }

    @Test
    public void test_division() throws InvalidPolynomException {
        Polynom p1 = new Polynom();
        p1.getBody().add(new Monom(1,1));
        p1.getBody().add(new Monom(1,0));

        Polynom p2 = new Polynom();
        p2.getBody().add(new Monom(1,2));
        p2.getBody().add(new Monom(2,1));
        p2.getBody().add(new Monom(1,0));

        DivisionRes division = model.divide(p2,p1);
        Polynom expectedQoutient = new Polynom();
        Polynom expectedRemainder = new Polynom();


        expectedQoutient.getBody().add(new Monom(1, 1));
        expectedQoutient.getBody().add(new Monom(1d, 0));

        expectedRemainder.getBody().add(new Monom(0, 0));
        assertTrue(model.comparePolynom(division.getQuotient(), expectedQoutient));
        //assertEquals(division.getQuotient(),expectedQoutient);
        assertTrue(model.comparePolynom(division.getRemainder(),expectedRemainder));
        //assertEquals(division.getRemainder(),expectedRemainder);
    }
}
