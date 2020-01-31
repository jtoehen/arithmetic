package co.jtoehen.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util
{

    public static int getIndexOfFirstDigit(String input)
    {
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(input);
        if(matcher.find())
            return matcher.start();
        return -1;
    }

    public static boolean validateBinaryOperand(String input)
    {
        Pattern pattern = Pattern.compile("\\d\\s*[\\+|\\-|\\*|\\/]\\s*\\d");
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    public static boolean validateRightOperand(String input)
    {
        Pattern pattern = Pattern.compile("\\s*[\\+|\\-|\\*|\\/]\\s*\\d");
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    public static boolean validateLeftOperand(String input)
    {
        Pattern pattern = Pattern.compile("\\d\\s*[\\+|\\-|\\*|\\/]\\s*");
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    public static int getIndexOfFirstOperatorRight(String input)
    {
        Pattern pattern = Pattern.compile("\\+|\\-|\\*|\\/");
        Matcher matcher = pattern.matcher(input);
        if(matcher.find())
            return matcher.start();
        return -1;
    }

    public static int getIndexOfFirstOperatorLeft(String input)
    {
        int y;
        Pattern pattern = Pattern.compile("\\+|\\-|\\*|\\/");
        Matcher matcher = pattern.matcher(new StringBuilder(input).reverse().toString());
        if(matcher.find())
            y = input.length() - matcher.start() -1;
        else
            y = 0;
        return y;
    }
}
