package cl.uchile.dcc.scrabble.model.hidden_layer.hidden_types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

import cl.uchile.dcc.scrabble.model.exceptions.ZeroDivisionException;
import cl.uchile.dcc.scrabble.model.utils.BinaryUtilities;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class HiddenIntTest extends BaseHTypeTest {

    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @RepeatedTest(20)
    void testCalculate() {
        assertEquals(hiddenInt1, hiddenInt1.calculate(),
            "Method calculate does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testAsString() {
        assertEquals(typeInt1.toString(), hiddenInt1.asString(0),
            "Method asString dos not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testHashCode() {
        assertEquals(anInt1, hiddenInt1.hashCode(),
            "Method hashCode does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testEquals() {
        assertEquals(new HiddenInt(anInt1), hiddenInt1,
            "Method equals does not works." + messageSeed);
        assertNotEquals(hiddenInt2, hiddenInt1,
            "Method equals does not works." + messageSeed);
        assertNotEquals(hiddenInt1, typeInt1,
            "Method equals does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToHiddenBinary() {
        assertEquals(new HiddenBinary(BinaryUtilities.intToBinary(anInt1)), hiddenInt1.toHiddenBinary(),
            "Method toHiddenBinary does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToHiddenBool() {
        assertEquals(hiddenNull, hiddenInt1.toHiddenBool(),
            "Method toHiddenBool does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToHiddenFloat() {
        assertEquals(new HiddenFloat(anInt1), hiddenInt1.toHiddenFloat(),
            "Method toHiddenFloat does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToHiddenInt() {
        assertEquals(hiddenInt1, hiddenInt1.toHiddenInt(),
            "Method toHiddenInt does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToHiddenString() {
        assertEquals(new HiddenString(Integer.toString(anInt1)), hiddenInt1.toHiddenString(),
            "Method toHiddenString does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testGetAdaptee() {
        assertEquals(typeInt1, hiddenInt1.asSType(),
            "Method getAdaptee does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testToString() {
        assertEquals("HiddenInt{value=" + anInt1 + "}", hiddenInt1.toString(),
            "Method toString does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testNeg() {
        assertEquals(hiddenNull, hiddenInt1.neg(), "Method neg does not works." + messageSeed);
    }

    @RepeatedTest(20)
    void testAdd() {
        HiddenInt expected1 = new HiddenInt(
            anInt1 + BinaryUtilities.binaryToInt(aBinary1)
        );
        assertEquals(expected1, hiddenInt1.add(hiddenBinary1),
            "Method add does not works with binaries." + messageSeed);

        assertEquals(hiddenNull, hiddenInt1.add(trueHiddenBool),
            "Method add does not works with booleans." + messageSeed);
        assertEquals(hiddenNull, hiddenInt1.add(falseHiddenBool),
            "Method add does not works with booleans." + messageSeed);

        HiddenFloat expected3 = new HiddenFloat(
            anInt1 + aFloat1
        );
        assertEquals(expected3, hiddenInt1.add(hiddenFloat1),
            "Method add does not works with floats." + messageSeed);

        HiddenInt expected4 = new HiddenInt(
            anInt1 + anInt2
        );
        assertEquals(expected4, hiddenInt1.add(hiddenInt2),
            "Method add does not works with int." + messageSeed);

        assertEquals(hiddenNull, hiddenInt1.add(hiddenString1),
            "Method add does not works with strings." + messageSeed);
    }

    @RepeatedTest(20)
    void testDiv() {
        try {
            HiddenInt expected1 = new HiddenInt(
                (int) Math.round((double) anInt1 / BinaryUtilities.binaryToInt(aBinary1))
            );
            assertEquals(expected1, hiddenInt1.div(hiddenBinary1),
                "Method div does not works with binaries." + messageSeed);
        } catch (ZeroDivisionException e) {
            assertEquals(0, Math.abs(hiddenBinary1.getValueAsDouble()),
                "Exception fails.");
        }

        try {
            assertEquals(hiddenNull, hiddenInt1.div(trueHiddenBool),
                "Method div does not works with booleans." + messageSeed);
            assertEquals(hiddenNull, hiddenInt1.div(falseHiddenBool),
                "Method div does not works with booleans." + messageSeed);
        } catch (ZeroDivisionException e) {
            fail("Exception fails.");
        }

        try {
            HiddenFloat expected3 = new HiddenFloat(
                anInt1 / aFloat1
            );
            assertEquals(expected3, hiddenInt1.div(hiddenFloat1),
                "Method div does not works with floats." + messageSeed);
        } catch (ZeroDivisionException e) {
            assertEquals(0, Math.abs(hiddenFloat1.getValueAsDouble()),
                "Exception fails.");
        }

        try {
            HiddenInt expected4 = new HiddenInt(
                (int) Math.round((double) anInt1 / anInt2)
            );
            assertEquals(expected4, hiddenInt1.div(hiddenInt2),
                "Method div does not works with int." + messageSeed);
        } catch (ZeroDivisionException e) {
            assertEquals(0, Math.abs(hiddenInt2.getValueAsDouble()),
                "Exception fails.");
        }

        try {
            assertEquals(hiddenNull, hiddenInt1.div(hiddenString1),
                "Method div does not works with strings." + messageSeed);
        } catch (ZeroDivisionException e) {
            fail("Exception fails.");
        }
    }

    @RepeatedTest(20)
    void testMult() {
        HiddenInt expected1 = new HiddenInt(
            anInt1 * BinaryUtilities.binaryToInt(aBinary1)
        );
        assertEquals(expected1, hiddenInt1.mult(hiddenBinary1),
            "Method mult does not works with binaries." + messageSeed);

        assertEquals(hiddenNull, hiddenInt1.mult(trueHiddenBool),
            "Method mult does not works with booleans." + messageSeed);
        assertEquals(hiddenNull, hiddenInt1.mult(falseHiddenBool),
            "Method mult does not works with booleans." + messageSeed);

        HiddenFloat expected3 = new HiddenFloat(
            anInt1 * aFloat1
        );
        assertEquals(expected3, hiddenInt1.mult(hiddenFloat1),
            "Method mult does not works with floats." + messageSeed);


        HiddenInt expected4 = new HiddenInt(
            anInt1 * anInt2
        );
        assertEquals(expected4, hiddenInt1.mult(hiddenInt2),
            "Method mult does not works with int." + messageSeed);

        assertEquals(hiddenNull, hiddenInt1.mult(hiddenString1),
            "Method mult does not works with strings." + messageSeed);
    }

    @RepeatedTest(20)
    void testSub() {
        HiddenInt expected1 = new HiddenInt(
            anInt1 - BinaryUtilities.binaryToInt(aBinary1)
        );
        assertEquals(expected1, hiddenInt1.sub(hiddenBinary1),
            "Method sub does not works with binaries." + messageSeed);

        assertEquals(hiddenNull, hiddenInt1.sub(trueHiddenBool),
            "Method sub does not works with booleans." + messageSeed);
        assertEquals(hiddenNull, hiddenInt1.sub(falseHiddenBool),
            "Method sub does not works with booleans." + messageSeed);

        HiddenFloat expected3 = new HiddenFloat(
            anInt1 - aFloat1
        );
        assertEquals(expected3, hiddenInt1.sub(hiddenFloat1),
            "Method sub does not works with floats." + messageSeed);

        HiddenInt expected4 = new HiddenInt(
            anInt1 - anInt2
        );
        assertEquals(expected4, hiddenInt1.sub(hiddenInt2),
            "Method sub does not works with int." + messageSeed);

        assertEquals(hiddenNull, hiddenInt1.sub(hiddenString1),
            "Method sub does not works with strings." + messageSeed);
    }

    @RepeatedTest(20)
    void testAnd() {
        assertEquals(hiddenNull, hiddenInt1.and(hiddenBinary1),
            "Method and does not works with binaries." + messageSeed);

        assertEquals(hiddenNull, hiddenInt1.and(trueHiddenBool),
            "Method and does not works with booleans." + messageSeed);
        assertEquals(hiddenNull, hiddenInt1.and(falseHiddenBool),
            "Method and does not works with booleans." + messageSeed);

        assertEquals(hiddenNull, hiddenInt1.and(hiddenFloat1),
            "Method and does not works with floats." + messageSeed);

        assertEquals(hiddenNull, hiddenInt1.and(hiddenInt2),
            "Method and does not works with int." + messageSeed);

        assertEquals(hiddenNull, hiddenInt1.and(hiddenString1),
            "Method and does not works with strings." + messageSeed);
    }

    @RepeatedTest(20)
    void testOr() {
        assertEquals(hiddenNull, hiddenInt1.or(hiddenBinary1),
            "Method or does not works with binaries." + messageSeed);

        assertEquals(hiddenNull, hiddenInt1.or(trueHiddenBool),
            "Method or does not works with booleans." + messageSeed);
        assertEquals(hiddenNull, hiddenInt1.or(falseHiddenBool),
            "Method or does not works with booleans." + messageSeed);

        assertEquals(hiddenNull, hiddenInt1.or(hiddenFloat1),
            "Method or does not works with floats." + messageSeed);

        assertEquals(hiddenNull, hiddenInt1.or(hiddenInt2),
            "Method or does not works with int." + messageSeed);

        assertEquals(hiddenNull, hiddenInt1.or(hiddenString1),
            "Method or does not works with strings." + messageSeed);
    }

    @Test
    void testAsTypeInt() {
        assertEquals(typeInt1, hiddenInt1.asTypeInt(),
            "Method asTypeInt does not works." + messageSeed);
    }
}