import org.junit.jupiter.api.Test;
import model.Monom;
import model.Operations;
import model.Polynom;

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
    }
}
