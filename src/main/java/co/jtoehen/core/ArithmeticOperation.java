package co.jtoehen.core;

public enum ArithmeticOperation
{
    PLUS("+"),MINUS("-"),MULTIPLY("*"),DIVIDE("/"),OPENB("("),CLOSEB(")");

    private String operation;

    ArithmeticOperation(String operation)
    {
        this.operation = operation;
    }

    public String getOperation()
    {
        return operation;
    }

}