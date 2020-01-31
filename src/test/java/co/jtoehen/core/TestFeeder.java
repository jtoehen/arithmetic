package co.jtoehen.core;

import org.junit.Test;

import java.util.LinkedList;

public class TestFeeder
{
    @Test
    public void TestBase()
    {
        Feeder.calculate("1 + 1");
    }

    @Test
    public void TestMultipleOperation()
    {
        Feeder.calculate("1 + 1 * 3");
    }

    @Test
    public void TestSingleBracket()
    {
        Feeder.calculate("( 11.5 + 15.4 ) + 10.1");
    }

    @Test
    public void TestMultipleBrackets()
    {
        Feeder.calculate("10 - ( 2 + 3 * ( 7 - 5 ) )");
    }

    @Test
    public void TestPrioritizeOperation01()
    {
        String input = "1 + 1 * 3";
        LinkedList<String> output;

        output = Feeder.prioritizeOperation(input);

        for(String base: output)
        {
            System.out.println(">>" + base);
        }
    }

    @Test
    public void TestPrioritizeOperation02()
    {
        String input = "1 + 2 * 3 - 4 / 5";
        LinkedList<String> output;

        output = Feeder.prioritizeOperation(input);

        for(String base: output)
        {
            System.out.println(">>" + base);
        }
    }

    @Test
    public void TestPrioritizeOperation03()
    {
        String input = "7 - 5";
        LinkedList<String> output;

        output = Feeder.prioritizeOperation(input);

        for(String base: output)
        {
            System.out.println(">>" + base);
        }
    }
}
