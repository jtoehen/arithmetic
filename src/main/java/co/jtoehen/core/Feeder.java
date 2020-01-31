package co.jtoehen.core;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class Feeder
{
    private static List<String> operators = new ArrayList<String>();

    private final char multiply = '*';


    public static double calculate(String sum)
    {
        System.out.println("raw input : " + sum);

        Double result = 0.0;
        LinkedList<String> output = new LinkedList<>();

        // if string contains brackets, break it down
        deBracket(sum, 0, sum.length()-1, output);

        for(String base: output)
        {
            System.out.println(">>" + base);
            LinkedList<String> operation = new LinkedList<>();
            operation = prioritizeOperation(base);
            for(String suboperation : operation)
            {
                System.out.println(">>>> " + suboperation);

                if(Util.validateBinaryOperand(suboperation))
                    result = executeArithmetic(suboperation);
                else if(Util.validateLeftOperand(suboperation))
                {
                    result = executeArithmetic(suboperation + result);
                }
                else if(Util.validateRightOperand(suboperation))
                {
                    result = executeArithmetic(result + suboperation);
                }
            }
        }

        System.out.println("Result : " + result);

        return Double.valueOf(1);
    }

    public static LinkedList<String> deBracket(String input, int i, int j, LinkedList<String> output)
    {
        System.out.println("deBracket input : " + input);

        if(input.contains("(") || input.contains(")"))
        {
            int start = input.indexOf("(");
            int end = input.indexOf(")") != -1 ? input.indexOf(")") : input.length();
            int firstDigit = Util.getIndexOfFirstDigit(input);

            if(start < firstDigit)
            {
                output.push(input.substring(end+1, input.length()));
            }
            else
            {
                output.push(input.substring(0, start));
            }

            return deBracket(input.substring(start+1, end), start+1, end, output);
        }
        else
        {
            output.push(input);
            return output;
        }
    }

    public static LinkedList<String> prioritizeOperation(String input)
    {
        LinkedList<String> output = new LinkedList<>();
        System.out.println("prioritize input : [" + input + "]");

        int plusIndex = input.indexOf("+");
        int minusIndex = input.indexOf("-");
        int multiplyIndex = input.indexOf("*");
        int divideIndex = input.indexOf("/");
        int borderIndex;

        TreeSet<Integer> set = new TreeSet<>();

        if(multiplyIndex != -1)
        {
            int left = Util.getIndexOfFirstOperatorLeft(input.substring(0, multiplyIndex));
            int right = Util.getIndexOfFirstOperatorRight(input.substring(multiplyIndex+1, input.length()));
            if(right == -1)
                right = input.length();

            System.out.println(input.substring(left+1, right));
            output.add(input.substring(left+1, right));
        }
        if(divideIndex != -1)
        {
//            System.out.println("left " + input.substring(0, divideIndex));
            int left = Util.getIndexOfFirstOperatorLeft(input.substring(0, divideIndex));
//            System.out.println("right " + input.substring(divideIndex+1, input.length()));
            int right = Util.getIndexOfFirstOperatorRight(input.substring(divideIndex+1, input.length()));

            System.out.println(input.substring(left+1, right + divideIndex + 1));
            output.add(input.substring(left+1, right + divideIndex + 1));
        }
        if(plusIndex != -1)
        {
            String leftSubString = input.substring(0, plusIndex);
//            System.out.println("left " + leftSubString);
            int left = Util.getIndexOfFirstOperatorLeft(leftSubString);
//            System.out.println("right " + input.substring(plusIndex+1, input.length()));
            String rightSubString = input.substring(plusIndex+1, input.length());
//            System.out.println("righ " + rightSubString);
            int right = Util.getIndexOfFirstOperatorRight(rightSubString);
            if(right == -1)
                right = input.length();
//            System.out.println(input.substring(left, right));
            output.addLast(input.substring(left, right));
        }
        if(minusIndex != -1)
        {
            String leftSubString = input.substring(0, minusIndex);
//            System.out.println("left " + leftSubString);
            int left = Util.getIndexOfFirstOperatorLeft(leftSubString);
//            System.out.println(left + " [" + leftSubString + "] " + leftSubString.charAt(left));
            if(leftSubString.charAt(left) == '*' || leftSubString.charAt(left) == '/')
                left = minusIndex;

            String rightSubString = input.substring(minusIndex+1, input.length());
//            System.out.println("righ " + rightSubString);
            int right = Util.getIndexOfFirstOperatorRight(rightSubString);
//            System.out.println(right + " [" + rightSubString + "] ");
//            System.out.println(rightSubString.charAt(right));
            if(right == -1)
            {
                right = input.length();
            }
            else
            {
                if(rightSubString.charAt(right) == '*' || rightSubString.charAt(right) == '/')
                    right = minusIndex+1;
            }

//            System.out.println(input.substring(left, right));
            output.addLast(input.substring(left, right));
        }

        return output;
    }

    public static double executeArithmetic(String input)
    {
        System.out.println("Operation : " + input);

        if(input.contains("*"))
        {
            String operandLeft = input.substring(0, input.indexOf("*"));
            String operandRight = input.substring(input.indexOf("*")+1, input.length());

            return ArithmeticBaseOperator.multiply(Double.valueOf(operandLeft),Double.valueOf(operandRight));
        }
        else if(input.contains("/"))
        {
            String operandLeft = input.substring(0, input.indexOf("/"));
            String operandRight = input.substring(input.indexOf("/")+1, input.length());

            return ArithmeticBaseOperator.divide(Double.valueOf(operandLeft),Double.valueOf(operandRight));
        }
        else if(input.contains("+"))
        {
            String operandLeft = input.substring(0, input.indexOf("+"));
            String operandRight = input.substring(input.indexOf("+")+1, input.length());

            return ArithmeticBaseOperator.plus(Double.valueOf(operandLeft),Double.valueOf(operandRight));
        }
        else if(input.contains("-"))
        {
            String operandLeft = input.substring(0, input.indexOf("-"));
            String operandRight = input.substring(input.indexOf("-")+1, input.length());

            return ArithmeticBaseOperator.minus(Double.valueOf(operandLeft),Double.valueOf(operandRight));
        }
        else
        {
            return 0;
        }
    }
}
