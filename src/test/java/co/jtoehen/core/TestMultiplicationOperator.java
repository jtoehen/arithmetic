package co.jtoehen.core;

import org.junit.Test;

import java.util.ArrayList;

public class TestMultiplicationOperator
{
    @Test
    public void TestPrioritizeOperation01()
    {
        String input = "1 + 1 * 3";
        ArrayList<String> operatorArrayList;
        operatorArrayList =  MultiplicationOperator.processMultiplication(input);

        for(String operator: operatorArrayList)
        {
            System.out.print(" " + operator );
        }
    }

    @Test
    public void TestPrioritizeOperation02()
    {
        String input = "1 + 2 * 3 - 4 / 5";
        ArrayList<String> operatorArrayList;
        operatorArrayList = MultiplicationOperator.processMultiplication(input);

        for(String operator: operatorArrayList)
        {
            System.out.print(" " + operator );
        }
    }

    @Test
    public void TestPrioritizeOperation03()
    {
        String input = "7 - 5";
        ArrayList<String> operatorArrayList;
        operatorArrayList = MultiplicationOperator.processMultiplication(input);

        for(String operator: operatorArrayList)
        {
            System.out.print(" " + operator );
        }
    }

    @Test
    public void TestPrioritizeOperation04()
    {
        String input = " 2 + 3 * ";
        ArrayList<String> operatorArrayList;
        operatorArrayList = MultiplicationOperator.processMultiplication(input);

        for(String operator: operatorArrayList)
        {
            System.out.print(" " + operator );
        }
    }

    @Test
    public void TestPrioritizeOperation05()
    {
        String input = "1 + 2 + 3 / 4 + 5 + 6 * 7";
        ArrayList<String> operatorArrayList;
        operatorArrayList = MultiplicationOperator.processMultiplication(input);

        for(String operator: operatorArrayList)
        {
            System.out.print(" " + operator );
        }
    }

    @Test
    public void TestPrioritizeOperation06()
    {
        String input = "1 + 1 * 3";
        ArrayList<String> operatorArrayList;
        operatorArrayList = MultiplicationOperator.processMultiplication(input);

        for(String operator: operatorArrayList)
        {
            System.out.print(" " + operator );
        }
    }
}
