package co.jtoehen.core;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestUtil
{
    @Test
    public void TestGetIndex()
    {
        assertTrue(Util.getIndexOfFirstDigit("1+1") == 0);
        assertTrue(Util.getIndexOfFirstDigit("( 11.5 + 15.4 ) + 10.1") == 2);
    }

    @Test
    public void TestGetRightOperator()
    {
        assertTrue(Util.getIndexOfFirstOperatorRight("3-4/5") == 1);
        assertTrue(Util.getIndexOfFirstOperatorRight("3.5 - 4 / 5.5") == 4);
        assertTrue(Util.getIndexOfFirstOperatorRight("5") == -1);
    }

    @Test
    public void TestGetLeftOperator()
    {
        assertTrue(Util.getIndexOfFirstOperatorLeft("3-4/ 5") == 3);
        assertTrue(Util.getIndexOfFirstOperatorLeft("3.5 - 4 / 5.55") == 8);
        assertTrue(Util.getIndexOfFirstOperatorLeft("1 + 2 * 3 - 4 ") == 10);
    }

    @Test
    public void TestValidateBinary()
    {
        Util.validateBinaryOperand("1 + 1");
        Util.validateBinaryOperand("1+1");
        Util.validateBinaryOperand("11 + 11");
        Util.validateBinaryOperand(" 1 * 3");

        Util.validateBinaryOperand("11 +");
        Util.validateBinaryOperand("11 + ");
    }
}
