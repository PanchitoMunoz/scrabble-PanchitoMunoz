package cl.uchile.dcc.scrabble.model.hidden_ast.hidden_types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class HiddenFloatTest extends BaseHTypeTest {

    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @RepeatedTest(20)
    void testCalculate() {
        assertEquals(hiddenFloat1, hiddenFloat1.calculate(),
            "Method calculate does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testAsString() {
        assertEquals(typeFloat1.toString(), hiddenFloat1.asString(0),
            "Method asString dos not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testHashCode() {
        assertEquals(typeFloat1.hashCode(), hiddenFloat1.hashCode(),
            "Method hashCode does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testEquals() {
        assertEquals(new HiddenFloat(aFloat1), hiddenFloat1,
            "Method equals does not works." + messageSeed);
        assertNotEquals(hiddenFloat2, hiddenFloat1,
            "Method equals does not works." + messageSeed);
        assertNotEquals(hiddenFloat1, typeFloat1,
            "Method equals does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToHiddenBinary() {
        assertEquals(hiddenNull, hiddenFloat1.toHiddenBinary(),
            "Method toHiddenBinary does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToHiddenBool() {
        assertEquals(hiddenNull, hiddenFloat1.toHiddenBool(),
            "Method toHiddenBool does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToHiddenFloat() {
        assertEquals(hiddenFloat1, hiddenFloat1.toHiddenFloat(),
            "Method toHiddenFloat does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToHiddenInt() {
        assertEquals(hiddenNull, hiddenFloat1.toHiddenInt(),
            "Method toHiddenInt does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToHiddenString() {
        assertEquals(new HiddenString(typeFloat1.toTypeString()), hiddenFloat1.toHiddenString(),
            "Method toHiddenString does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testGetAdaptee() {
        assertEquals(typeFloat1, hiddenFloat1.toSType(),
            "Method getAdaptee does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToString() {
        assertEquals("HiddenFloat{value=" + aFloat1 + "}", hiddenFloat1.toString(),
            "Method toString does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testNeg() {
        assertEquals(hiddenNull, hiddenFloat1.neg(), "Method neg does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testAdd() {
        HiddenFloat expected1 = new HiddenFloat(typeFloat1.add(typeBinary1));
        assertEquals(expected1, hiddenFloat1.add(hiddenBinary1),
            "Method add does not works with binaries." + messageSeed);

        assertEquals(hiddenNull, hiddenFloat1.add(trueHiddenBool),
            "Method add does not works with booleans." + messageSeed);
        assertEquals(hiddenNull, hiddenFloat1.add(falseHiddenBool),
            "Method add does not works with booleans." + messageSeed);

        HiddenFloat expected3 = new HiddenFloat(typeFloat1.add(typeFloat2));
        assertEquals(expected3, hiddenFloat1.add(hiddenFloat2),
            "Method add does not works with floats." + messageSeed);

        HiddenFloat expected4 = new HiddenFloat(typeFloat1.add(typeInt1));
        assertEquals(expected4, hiddenFloat1.add(hiddenInt1),
            "Method add does not works with int." + messageSeed);

        assertEquals(hiddenNull, hiddenFloat1.add(hiddenString1),
            "Method add does not works with strings." + messageSeed);
    }

    @RepeatedTest(20)
    void testDiv() {
        HiddenFloat expected1 = new HiddenFloat(typeFloat1.div(typeBinary1));
        assertEquals(expected1, hiddenFloat1.div(hiddenBinary1),
            "Method div does not works with binaries." + messageSeed);

        assertEquals(hiddenNull, hiddenFloat1.div(trueHiddenBool),
            "Method div does not works with booleans." + messageSeed);
        assertEquals(hiddenNull, hiddenFloat1.div(falseHiddenBool),
            "Method div does not works with booleans." + messageSeed);

        HiddenFloat expected3 = new HiddenFloat(typeFloat1.div(typeFloat2));
        assertEquals(expected3, hiddenFloat1.div(hiddenFloat2),
            "Method div does not works with floats." + messageSeed);

        HiddenFloat expected4 = new HiddenFloat(typeFloat1.div(typeInt1));
        assertEquals(expected4, hiddenFloat1.div(hiddenInt1),
            "Method div does not works with int." + messageSeed);

        assertEquals(hiddenNull, hiddenFloat1.div(hiddenString1),
            "Method div does not works with strings." + messageSeed);
    }

    @RepeatedTest(20)
    void testMult() {
        HiddenFloat expected1 = new HiddenFloat(typeFloat1.mult(typeBinary1));
        assertEquals(expected1, hiddenFloat1.mult(hiddenBinary1),
            "Method mult does not works with binaries." + messageSeed);

        assertEquals(hiddenNull, hiddenFloat1.mult(trueHiddenBool),
            "Method mult does not works with booleans." + messageSeed);
        assertEquals(hiddenNull, hiddenFloat1.mult(falseHiddenBool),
            "Method mult does not works with booleans." + messageSeed);

        HiddenFloat expected3 = new HiddenFloat(typeFloat1.mult(typeFloat2));
        assertEquals(expected3, hiddenFloat1.mult(hiddenFloat2),
            "Method mult does not works with floats." + messageSeed);

        HiddenFloat expected4 = new HiddenFloat(typeFloat1.mult(typeInt1));
        assertEquals(expected4, hiddenFloat1.mult(hiddenInt1),
            "Method mult does not works with int." + messageSeed);

        assertEquals(hiddenNull, hiddenFloat1.mult(hiddenString1),
            "Method mult does not works with strings." + messageSeed);
    }

    @RepeatedTest(20)
    void testSub() {
        HiddenFloat expected1 = new HiddenFloat(typeFloat1.sub(typeBinary1));
        assertEquals(expected1, hiddenFloat1.sub(hiddenBinary1),
            "Method sub does not works with binaries." + messageSeed);

        assertEquals(hiddenNull, hiddenFloat1.sub(trueHiddenBool),
            "Method sub does not works with booleans." + messageSeed);
        assertEquals(hiddenNull, hiddenFloat1.sub(falseHiddenBool),
            "Method sub does not works with booleans." + messageSeed);

        HiddenFloat expected3 = new HiddenFloat(typeFloat1.sub(typeFloat2));
        assertEquals(expected3, hiddenFloat1.sub(hiddenFloat2),
            "Method sub does not works with floats." + messageSeed);

        HiddenFloat expected4 = new HiddenFloat(typeFloat1.sub(typeInt1));
        assertEquals(expected4, hiddenFloat1.sub(hiddenInt1),
            "Method sub does not works with int." + messageSeed);

        assertEquals(hiddenNull, hiddenFloat1.sub(hiddenString1),
            "Method sub does not works with strings." + messageSeed);
    }

    @RepeatedTest(20)
    void testAnd() {
        assertEquals(hiddenNull, hiddenFloat1.and(hiddenBinary1),
            "Method and does not works with binaries." + messageSeed);

        assertEquals(hiddenNull, hiddenFloat1.and(trueHiddenBool),
            "Method and does not works with booleans." + messageSeed);
        assertEquals(hiddenNull, hiddenFloat1.and(falseHiddenBool),
            "Method and does not works with booleans." + messageSeed);

        assertEquals(hiddenNull, hiddenFloat1.and(hiddenFloat2),
            "Method and does not works with floats." + messageSeed);

        assertEquals(hiddenNull, hiddenFloat1.and(hiddenInt1),
            "Method and does not works with int." + messageSeed);

        assertEquals(hiddenNull, hiddenFloat1.and(hiddenString1),
            "Method and does not works with strings." + messageSeed);
    }

    @RepeatedTest(20)
    void testOr() {
        assertEquals(hiddenNull, hiddenFloat1.or(hiddenBinary1),
            "Method or does not works with binaries." + messageSeed);

        assertEquals(hiddenNull, hiddenFloat1.or(trueHiddenBool),
            "Method or does not works with booleans." + messageSeed);
        assertEquals(hiddenNull, hiddenFloat1.or(falseHiddenBool),
            "Method or does not works with booleans." + messageSeed);

        assertEquals(hiddenNull, hiddenFloat1.or(hiddenFloat2),
            "Method or does not works with floats." + messageSeed);

        assertEquals(hiddenNull, hiddenFloat1.or(hiddenInt1),
            "Method or does not works with int." + messageSeed);

        assertEquals(hiddenNull, hiddenFloat1.or(hiddenString1),
            "Method or does not works with strings." + messageSeed);
    }
}