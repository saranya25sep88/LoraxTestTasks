import org.example.ArithmeticOperations;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestArithmetic {

    @ParameterizedTest
    @CsvSource({
            "add, 5, 3, 8",
            "add, -5, -3, -8",
            "add, 7, -2, 5",
            "add, 0, 0, 0",
            "subtract, 5, 3, 2",
            "subtract, -5, -3, -2",
            "subtract, 7, -2, 9",
            "subtract, 5, 0, 5",
            "multiply, 5, 3, 15",
            "multiply, -5, -3, 15",
            "multiply, 7, -2, -14",
            "multiply, 5, 0, 0",
            "divide, 6, 3, 2.0",
            "divide, -6, -3, 2.0",
            "divide, 7, -2, -3.5",
            "divide, 0, 5, 0.0"
    })
    public void testArithmeticOperations(String operation, double num1, double num2, double expectedResult) {
        double result = 0.0;
        switch (operation) {
            case "add":
                result = ArithmeticOperations.add(num1, num2);
                break;
            case "subtract":
                result = ArithmeticOperations.subtract(num1, num2);
                break;
            case "multiply":
                result = ArithmeticOperations.multiply(num1, num2);
                break;
            case "divide":
                if (num2 == 0) {
                    assertThrows(ArithmeticException.class, () -> ArithmeticOperations.divide(num1,num2));
                    return;
                }
                result = ArithmeticOperations.divide(num1,num2);
                break;
        }
        assertEquals(expectedResult, result, "Result of " + operation + " operation is incorrect");
    }
}

