package task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import task1.TaylorAcos;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Tests for TaylorAcos")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TaylorAcosTest extends Assertions {
    private final double delta = 1e-8;

    @ParameterizedTest(name = "Test from -1.1 to 1.1 with step 0.1")
    @CsvFileSource(resources = "../testdata.csv")
    public void getAcosTestStep(double x) {
        double actual = TaylorAcos.getAcos(x);
        double expected = Math.acos(x);
        System.out.println("X = "+ x);
        System.out.println("Expected = "+ expected);
        System.out.println("Actual = "+ actual);
        assertEquals(expected,actual,delta);

    }

    @Test
    public void getAcosTestZero() {
        double x = 0;
        double expected = TaylorAcos.getAcos(x);
        double actual = Math.acos(x);
        System.out.println("X = "+ x);
        System.out.println("Expected = "+ expected);
        System.out.println("Actual = "+ actual);
        assertEquals(expected,actual,delta);
    }
    @Test
    public void getAcosTestOne() {
        double x = 1;
        double actual = TaylorAcos.getAcos(x);
        double expected = Math.acos(x);
        System.out.println("X = "+ x);
        System.out.println("Expected = "+ expected);
        System.out.println("Actual = "+ actual);
        assertEquals(expected,actual,delta);
    }
    @Test
    public void getAcosTestMinusOne() {
        double x = -1;
        double actual = TaylorAcos.getAcos(x);
        double expected = Math.acos(x);
        System.out.println("X = "+ x);
        System.out.println("Expected = "+ expected);
        System.out.println("Actual = "+ actual);
        assertEquals(expected,actual,0.0001);
    }

}