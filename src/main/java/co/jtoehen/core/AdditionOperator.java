package co.jtoehen.core;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class AdditionOperator extends ArithmeticBaseOperator
{
    public static double processAddition(ArrayList<String> firstTier)
    {
        int i = firstTier.size() - 1;
        if(i == 0)
            return Double.valueOf(firstTier.get(i));

        String left;
        String right = "0";

        while(i >= 0)
        {
            String content = firstTier.get(i);

            if(content.equalsIgnoreCase("+") ||
                    content.equalsIgnoreCase("-"))
            {
                left = firstTier.get(i-1);

                if(i == firstTier.size() - 2) // first operator
                {
                    right = firstTier.get(i+1);
                }

                if(content.equalsIgnoreCase("+"))
                {
                    double output = plus(Double.valueOf(left),
                            Double.valueOf(right));
                    right = String.valueOf(output);
                }

                if(content.equalsIgnoreCase("-"))
                {
                    double output = minus(Double.valueOf(left),
                            Double.valueOf(right));
                    output = new BigDecimal(output).setScale(2, RoundingMode.HALF_UP).doubleValue();
                    right = String.valueOf(0 - output);
                }
            }
            i--;
        }

        return Double.valueOf(right);
    }
}
