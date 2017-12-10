import Operations.Divider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class Parameterized_UnitTest {

    private String dividend;
    private String divider;
    private String expected;

    public Parameterized_UnitTest(String dividendA, String DividerB, String expected) {
        this.dividend = dividendA;
        this.divider = DividerB;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}:division({0}/{1})={2}")
    public static Iterable<Object[]> dataForTest() {
        return Arrays.asList(new Object[][]{
                {"30", "2", "15"},
                {"220", "40", "5.5"},
                {"-50", "10", "-5"},
                {"33", "-3.3", "-10"},
                {"-8", "-4", "2"},
                {"", "2", "Error: dividend is incorrect or null!"},
                {"3", "", "Error: divider is incorrect or null!"},
                {"", "", "Error: dividend is incorrect or null!"},
                {"16", "0", "Error: Division by zero!"},
                {"0", "16", "0"},
                {"0", "0", "NaN"},
                {"2..5", "0", "Error: dividend is incorrect or null!"},
                {"44", ".5.65.7", "Error: divider is incorrect or null!"},
                {"4.56.7", "4.56.7", "Error: dividend is incorrect or null!"}
        });
    }

    @Test
    public void paramTest() {
        //assert
        assertEquals(expected, new Divider().Divide(dividend, divider));
    }
}