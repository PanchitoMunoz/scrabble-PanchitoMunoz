package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.transformations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.HiddenOperator;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.operators.BaseHiddenOperationTest;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_operators.unary_operators.ToHiddenFloat;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HType;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types.HiddenString;
import cl.uchile.dcc.scrabble.model.hidden_layer.hidden_variable.HiddenVariable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class ToHiddenFloatTest extends BaseHiddenOperationTest {

    @BeforeEach
    protected void setUp() {
        super.setUp();
    }

    @RepeatedTest(20)
    void testToString() {
        String templateString = "%s.toTypeFloat()";
        for (HType hType1 : hTypeList2) {
            String expected = String.format(templateString, hType1.asString(0));
            assertEquals(expected, new ToHiddenFloat(hType1).toString(),
                "Method toString does not works." + messageSeed);
        }
    }

    @RepeatedTest(20)
    void testCalculate() {
        // String
        assertEquals(hiddenNull, new ToHiddenFloat(hiddenString1).calculate(),
            "Method calculate does not works with string type." + messageSeed);
        // Bool
        assertEquals(hiddenNull, new ToHiddenFloat(trueHiddenBool).calculate(),
            "Method calculate does not works with bool type." + messageSeed);
        assertEquals(hiddenNull, new ToHiddenFloat(falseHiddenBool).calculate(),
            "Method calculate does not works with bool type." + messageSeed);
        // float
        assertEquals(hiddenFloat1.toHiddenFloat(), new ToHiddenFloat(hiddenFloat1).calculate(),
            "Method calculate does not works with float type." + messageSeed);
        // int
        assertEquals(hiddenInt1.toHiddenFloat(), new ToHiddenFloat(hiddenInt1).calculate(),
            "Method calculate does not works with int type." + messageSeed);
        // int
        assertEquals(hiddenBinary1.toHiddenFloat(), new ToHiddenFloat(hiddenBinary1).calculate(),
            "Method calculate does not works with binary type." + messageSeed);
    }

    @RepeatedTest(20)
    void testCopy() {
        ToHiddenFloat operation = new ToHiddenFloat(hiddenFloat1);
        HiddenOperator other = operation.copy();
        assertNotSame(other, operation);
        assertSame(other.getFirstChildren(), operation.getFirstChildren());
    }

    @Test
    void testAsCode() {
        HiddenOperator operator = new ToHiddenFloat(new HiddenString("Hola Mundo"));
        String expected = "\"Hola Mundo\".toTypeFloat()";
        assertEquals(expected, operator.asCode(),
            "Method asCode does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testAccept() {
        HiddenOperator operator = new ToHiddenFloat(
            new HiddenVariable("x")
        );
        operator.setVariable("x", hiddenFloat1);
        assertEquals(hiddenFloat1, operator.calculate(),
            "Method accept does not works." + messageSeed);
    }
}