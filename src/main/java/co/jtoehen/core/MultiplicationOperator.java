package co.jtoehen.core;

import java.util.ArrayList;
import java.util.Arrays;

public class MultiplicationOperator extends ArithmeticBaseOperator
{
    public static ArrayList<String> processMultiplication(String input)
    {
        String[] raw = input.trim().split(" ");

        ArrayList<String> data = new ArrayList<>(Arrays.asList(raw));
        ArrayList<String> firstTier = new ArrayList();
        int i = data.size() - 1;

        while(i >= 0)
        {
            String content = data.get(i);

            if(content.equalsIgnoreCase("*") ||
                    content.equalsIgnoreCase("/"))
            {
                String left = data.get(i-1);
                String right = data.get(i+1);
                if(content.equalsIgnoreCase("*"))
                {
                    double output = multiply(Double.valueOf(left), Double.valueOf(right));
                    firstTier.add(String.valueOf(output));
                }

                if(content.equalsIgnoreCase("/"))
                {
                    double output = divide(Double.valueOf(left), Double.valueOf(right));
                    firstTier.add(String.valueOf(output));
                }
            }
            else if(content.equalsIgnoreCase("+") ||
                    content.equalsIgnoreCase("-"))
            {
                String leftOperator = i-2 >= 0 ? data.get(i-2) : null;
                String rightOperator = i+2 < data.size() ? data.get(i+2) : null;

                if(rightOperator == null)
                {
                    firstTier.add(data.get(i+1));
                    firstTier.add(data.get(i));
                }
                else
                {
                    if(rightOperator.equalsIgnoreCase("*") ||
                            rightOperator.equalsIgnoreCase("/"))
                    {
                        firstTier.add(content);
                    }
                    else
                    {
                        firstTier.add(data.get(i+1));
                        firstTier.add(data.get(i));
                    }
                }

                if(leftOperator == null)
                {
                    firstTier.add(data.get(i-1));
                }
                else
                {
                    if(leftOperator.equalsIgnoreCase("*") ||
                            leftOperator.equalsIgnoreCase("/"))
                    {
//                        firstTier.add(content);
                    }
                    else
                    {
//                        firstTier.add(data.get(i-1));
                    }
                }

            }
            else
            {
                // do nothing on numbers.
            }

            i--;
        }
        return firstTier;
    }
}
