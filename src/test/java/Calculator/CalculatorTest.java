package Calculator;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private static Calculator calculator;

    @BeforeClass
    public static void init() {
        calculator = new Calculator();
    }
    @Test
    public void valueOne() throws Exception {
        assertEquals(calculator.add("1"), 1);
    }

    @Test
    public void emptyCase() throws Exception {
        assertEquals(calculator.add(""), 0);
    }

    @Test
    public void sumOf5Numbers() throws Exception {
        assertEquals(calculator.add("7,1,2,3,9"), 22);
    }

    @Test
    public void numbersAndNewLines() throws Exception {
        assertEquals(calculator.add("1,2,3\n\n\n\n\n"), 6);
    }

    @Test
    public void delimitersNumbers() throws Exception {
        assertEquals(calculator.add("//;\\;\\1;2,;3"), 6);
    }

    @Test
    public void allCharacters() throws Exception {
        assertEquals(calculator.add("/\n1,2;4*&^4$$3&1"), 15);
    }


    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void shouldThrowRuntimeExceptionWhenNumberIsNegative() throws Exception {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("negatives not allowed :: [-1]");
        calculator.add("-1");
    }
}