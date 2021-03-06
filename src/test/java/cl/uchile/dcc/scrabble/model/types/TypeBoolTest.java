package cl.uchile.dcc.scrabble.model.types;

import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.boolAndBinary;
import static cl.uchile.dcc.scrabble.model.utils.BinaryUtilities.boolOrBinary;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class TypeBoolTest extends BaseTypeTest {

    @BeforeEach
    protected void setUp() {
        super.setUp();
    }

    @AfterEach
    protected void tearDown() {
        super.tearDown();
    }

    @Test
    void getValue() {
        assertEquals(trueBoolean, trueTypeBool.getValue(),
                "Method getValue does not works.");
        assertEquals(falseBoolean, falseTypeBool.getValue(),
                "Method getValue does not works.");
        assertNotEquals(trueBoolean, falseTypeBool.getValue(),
                "Method getValue does not works.");
        assertNotEquals(falseBoolean, trueTypeBool.getValue(),
                "Method getValue does not works.");
    }

    @Test
    void testEquals() {
        TypeBool otherTrueTypeBool = new TypeBool(trueBoolean);
        TypeBool otherFalseTypeBool = new TypeBool(falseBoolean);
        assertEquals(otherTrueTypeBool, trueTypeBool,
                "Same instances are not equals.");
        assertEquals(otherFalseTypeBool, falseTypeBool,
                "Same instances are not equals.");
        assertNotEquals(trueTypeBool, falseTypeBool,
                "Different instances are equals");
    }

    @Test
    void testHashCode() {
        TypeBool otherTrueTypeBool = new TypeBool(trueBoolean);
        TypeBool otherFalseTypeBool = new TypeBool(falseBoolean);
        assertEquals(otherTrueTypeBool.hashCode(), trueTypeBool.hashCode(),
                "Hash Codes are not equals.");
        assertEquals(otherFalseTypeBool.hashCode(), falseTypeBool.hashCode(),
                "Hash Codes are not equals.");
        assertNotEquals(trueTypeBool.hashCode(), falseTypeBool.hashCode(),
                "Hash Codes of different instances are equals.");
    }

    @Test
    void testToString() {
        assertEquals("TypeBool{value=true}", trueTypeBool.toString(),
                "toString method does not work with true.");
        assertEquals("TypeBool{value=false}", falseTypeBool.toString(),
                "toString method does not work with false.");
    }

    @Test
    void toTypeString() {
        TypeString trueTypeString = new TypeString(Boolean.toString(trueBoolean));
        TypeString falseTypeString = new TypeString(Boolean.toString(falseBoolean));
        // Case equals
        assertEquals(trueTypeString, trueTypeBool.toTypeString(),
                "The method toTypeString does not works.");
        assertEquals(falseTypeString, falseTypeBool.toTypeString(),
                "The method toTypeString does not works.");
        // Case not equals
        assertNotEquals(falseTypeString, trueTypeBool.toTypeString(),
                "The method toTypeString does not works.");
        assertNotEquals(trueTypeString, falseTypeBool.toTypeString(),
                "The method toTypeString does not works.");
    }

    @Test
    void toTypeBool() {
        TypeBool otherTrueTypeBool = new TypeBool(trueBoolean);
        TypeBool otherFalseTypeBool = new TypeBool(falseBoolean);
        assertEquals(otherTrueTypeBool, trueTypeBool.toTypeBool(),
                "The method toTypeBool does not works with true.");
        assertEquals(otherFalseTypeBool, falseTypeBool.toTypeBool(),
                "The method toTypeBool does not works with false.");
        assertNotEquals(otherFalseTypeBool, trueTypeBool.toTypeBool(),
                "The method toTypeBool does not works with different values.");
        assertNotEquals(otherTrueTypeBool, falseTypeBool.toTypeBool(),
                "The method toTypeBool does not works with different values.");
    }

    @Test
    void neg() {
        assertEquals(falseTypeBool, trueTypeBool.neg(),
                "Method neg does not works with true.");
        assertEquals(trueTypeBool, falseTypeBool.neg(),
                "Method neg does not works with false.");
    }

    @RepeatedTest(20)
    void and() {
        // And with booleans
        assertEquals(trueTypeBool, trueTypeBool.and(trueTypeBool),
                "Method and does not works with true and true booleans.");
        assertEquals(falseTypeBool, trueTypeBool.and(falseTypeBool),
                "Method and does not works with true and false booleans.");
        assertEquals(falseTypeBool, falseTypeBool.and(trueTypeBool),
                "Method and does not works with false and true booleans.");
        assertEquals(falseTypeBool, falseTypeBool.and(falseTypeBool),
                "Method and does not works with false and false booleans.");
        // And with binaries
        var trueAndBinary = boolAndBinary(trueBoolean, aBinary1);
        var expected = new TypeBinary(trueAndBinary);
        assertEquals(expected, trueTypeBool.and(typeBinary1),
                "Method and does not works with true bool and a binary." + messageSeed);
        var falseAndBinary = boolAndBinary(falseBoolean, aBinary1);
        expected = new TypeBinary(falseAndBinary);
        assertEquals(expected, falseTypeBool.and(typeBinary1),
                "Method and does not works with false bool and a binary." + messageSeed);
    }

    @RepeatedTest(20)
    void or() {
        // Or with booleans
        assertEquals(trueTypeBool, trueTypeBool.or(trueTypeBool),
                "Method or does not works with true and true booleans.");
        assertEquals(trueTypeBool, trueTypeBool.or(falseTypeBool),
                "Method or does not works with true and false booleans.");
        assertEquals(trueTypeBool, falseTypeBool.or(trueTypeBool),
                "Method or does not works with false and true booleans.");
        assertEquals(falseTypeBool, falseTypeBool.or(falseTypeBool),
                "Method or does not works with false and false booleans.");
        // Or with binaries
        var trueOrBinary = boolOrBinary(trueBoolean, aBinary1);
        var expected = new TypeBinary(trueOrBinary);
        assertEquals(expected, trueTypeBool.or(typeBinary1),
                "Method or does not works with true bool and a binary." + messageSeed);
        var falseOrBinary = boolOrBinary(falseBoolean, aBinary1);
        expected = new TypeBinary(falseOrBinary);
        assertEquals(expected, falseTypeBool.or(typeBinary1),
                "Method or does not works with false bool and a binary." + messageSeed);
    }
}