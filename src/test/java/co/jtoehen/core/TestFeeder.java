package co.jtoehen.core;

import org.junit.Test;

public class TestFeeder
{
    @Test
    public void TestBase()
    {
        assert(Feeder.calculate("1 + 1") == 2.0);
        assert(Feeder.calculate("2 * 2") == 4.0);
        assert(Feeder.calculate("6 / 2") == 3.0);
        assert(Feeder.calculate("11 + 23") == 34.0);
        assert(Feeder.calculate("11.1 + 23") == 34.1);
        assert(Feeder.calculate("21.1 - 13.9") == 7.2);
    }

    @Test
    public void TestMultipleOperation()
    {
        assert(Feeder.calculate("1 + 1 * 3") == 4.0);
        assert(Feeder.calculate("1 + 2 + 3") == 6.0);
    }

    @Test
    public void TestSingleBracket()
    {
        assert(Feeder.calculate("( 11.5 + 15.4 ) + 10.1") == 37.0);
        assert(Feeder.calculate("23 - ( 29.3 - 12.5 )") == 6.2);
    }

    @Test
    public void TestMultipleBrackets()
    {
        assert(Feeder.calculate("10 - ( 2 + 3 * ( 7 - 5 ) )") == 2.0);
//        assert(Feeder.calculate("10 - 8 + ( ( 2 + 3 ) * ( 7 - 5 ) )") == 2.0);
    }
}
