package co.jtoehen.core;

import java.util.*;

public class Feeder
{
    public static double calculate(String sum)
    {
        System.out.println("Raw input : " + sum);

        Double result = 0.0;
        LinkedList<String> output = new LinkedList<>();
        ArrayList<Integer[]> leftBrackets = new ArrayList<>();
        ArrayList<Integer> rightBrackets = new ArrayList<>();
        HashMap<Integer, Integer[]> bracketGroups = new HashMap<>();

        extractBrackets(sum, leftBrackets, rightBrackets);

        bracketGroups = groupBrackets(leftBrackets,rightBrackets);

        // if string contains brackets, break it down
        deBracket(sum, 0, sum.length()-1, output);

//        for(String base: output)
//        {
//            System.out.println(">> [" + base + "]");
//        }

        for(String base: output)
        {
            String cleanBase = base.trim();
            if(cleanBase.split(" ").length % 2 == 0)
            {
                if(Util.validateLeftOperand(base))
                {
                    System.out.print("Operation : " + base + result);
                    result = AdditionOperator.processAddition(MultiplicationOperator.processMultiplication(base + result));
                    System.out.println(" = " + result);
                }
                else if(Util.validateRightOperand(base))
                {
                    System.out.print("Operation : " + result + base);
                    result = AdditionOperator.processAddition(MultiplicationOperator.processMultiplication(result + base));
                    System.out.println(" = " + result);
                }
            }
            else
            {
                result = AdditionOperator.processAddition(MultiplicationOperator.processMultiplication(cleanBase));
                System.out.println("Operation : " + cleanBase + " = " + result);
            }
        }

        System.out.println("Result : " + result);

        return result;
    }

    public static LinkedList<String> deBracket(String input, int i, int j, LinkedList<String> output)
    {
//        System.out.println("deBracket input : " + input);

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

    public static LinkedList<String> deBracket02(String input, HashMap<Integer, Integer[]> bracketGroups, LinkedList<String> output)
    {
        System.out.println("deBracket input : " + input);

        if(input.contains("("))
        {
            int start = input.indexOf("(");
            Integer[] coord = bracketGroups.get(start);
            int firstDigit = Util.getIndexOfFirstDigit(input);

            if(start < firstDigit)
            {
                output.push(input.substring(coord[1], input.length()));
            }
            else
            {
                output.push(input.substring(0, start));
            }

            return deBracket02(input.substring(start+1, coord[1]), bracketGroups, output);
        }
        else
        {
            output.push(input);
            return output;
        }
    }

    public static void extractBrackets(String input, ArrayList<Integer[]> leftBrackets, ArrayList<Integer> rightBrackets)
    {
        input = input.trim();
        String[] raw = input.split(" ");
        int i = 0;
        int ind = -1;
        while(i < raw.length)
        {
            ind++;

            if(raw[i].equalsIgnoreCase("("))
            {
                leftBrackets.add(new Integer[]{ind,i});
            }

            if(raw[i].equalsIgnoreCase(")"))
            {
                rightBrackets.add(i);
            }

            ind=ind+raw[i].length();
            i++;
        }
    }

    public static HashMap<Integer, Integer[]> groupBrackets(ArrayList<Integer[]> leftBrackets, ArrayList<Integer> rightBrackets)
    {
        HashMap<Integer, Integer[]> bracketGroup = new HashMap<>();
        int i = leftBrackets.size() - 1;
        int j;
        while(i >= 0)
        {
            Integer[] leftInd = leftBrackets.get(i);
            j = 0;

            while(j < rightBrackets.size())
            {
                int rightInd = rightBrackets.get(j);

                if(leftInd[1] < rightInd)
                {
                    bracketGroup.put(leftInd[0], new Integer[]{leftInd[1], rightInd});
                    leftBrackets.remove(i);
                    rightBrackets.remove(j);
                    break;
                }
                j++;
            }
            i--;
        }

        return bracketGroup;
    }

}
