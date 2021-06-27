package cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_operations.operations;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.ast.hidden_ast.hidden_types.HType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class HiddenDivTest extends BaseHiddenOperationTest {

    @BeforeEach
    protected void setUp() {
        super.setUp();
    }

    @RepeatedTest(20)
    void testTestToString() {
        String templateString = (
            "Div(\n" 
            + "  %s /\n"
            + "  %s\n"
            + ")"
        );
        for (HType hType1 : hTypeList2) {
            for (HType hType2 : hTypeList2) {
                String expected = String.format(templateString,
                    hType1.asString(0), hType2.asString(0));
                assertEquals(expected, new HiddenDiv(hType1, hType2).toString(),
                    "Method toString does not works." + messageSeed);
            }
        }
    }

    @RepeatedTest(20)
    void testCalculate() {
        // Div with String
        for (HType hType : hTypeList2) {
            HType expected1 = hiddenString1.div(hType);
            assertEquals(expected1, new HiddenDiv(hiddenString1, hType).calculate(),
                "Method div does not works with string type." + messageSeed);
        }
        // Div with bool
        for (HType hType : hTypeList2) {
            assertNull(new HiddenDiv(trueHiddenBool, hType).calculate(),
                "Method div does not works with bool type." + messageSeed);
            assertNull(new HiddenDiv(falseHiddenBool, hType).calculate(),
                "Method div does not works with bool type." + messageSeed);
        }
        // Div with float
        for (HType hType : hNumberList) {
            HType expected1 = hiddenFloat1.div(hType);
            assertEquals(expected1, new HiddenDiv(hiddenFloat1, hType).calculate(),
                "Method div does not works with float type." + messageSeed);
        }
        for (HType hType : hNumberCList) {
            assertNull(new HiddenDiv(hiddenFloat1, hType).calculate(),
                "Method div does not works with float type." + messageSeed);
        }
        // Div with int
        for (HType hType : hNumberList) {
            HType expected1 = hiddenInt1.div(hType);
            assertEquals(expected1, new HiddenDiv(hiddenInt1, hType).calculate(),
                "Method div does not works with int type." + messageSeed);
        }
        for (HType hType : hNumberCList) {
            assertNull(new HiddenDiv(hiddenInt1, hType).calculate(),
                "Method div does not works with int type." + messageSeed);
        }
        // Div with binary
        for (HType hType : hIntegerList) {
            HType expected1 = hiddenBinary1.div(hType);
            assertEquals(expected1, new HiddenDiv(hiddenBinary1, hType).calculate(),
                "Method div does not works with binary type." + messageSeed);
        }
        for (HType hType : hIntegerCList) {
            assertNull(new HiddenDiv(hiddenBinary1, hType).calculate(),
                "Method div does not works with binary type." + messageSeed);
        }
    }
}