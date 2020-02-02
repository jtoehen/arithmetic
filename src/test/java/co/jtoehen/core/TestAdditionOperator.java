package co.jtoehen.core;

import org.junit.Test;

public class TestAdditionOperator
{
    @Test
    public void TestPrioritizeOperation07()
    {
        String input = "1 + 2 + 3 / 4 + 5 + 6 * 7"; // 42.0 + 5 + 0.75 + 2 + 1
        System.out.println(AdditionOperator.processAddition(MultiplicationOperator.processMultiplication(input)));
    }

    @Test
    public void TestPrioritizeOperation08()
    {
        String input = "1 + 1 * 3"; // 3.0 + 1
        System.out.println(AdditionOperator.processAddition(MultiplicationOperator.processMultiplication(input)));
    }

    @Test
    public void TestPrioritizeOperation09()
    {
        String input = " 11.5 + 15.4 ";
        System.out.println(AdditionOperator.processAddition(MultiplicationOperator.processMultiplication(input)));
    }
}
