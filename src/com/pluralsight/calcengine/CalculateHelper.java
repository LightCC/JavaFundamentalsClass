package com.pluralsight.calcengine;

public class CalculateHelper {
    private static final char ADD_SYMBOL = '+';
    private static final char SUBTRACT_SYMBOL = '-';
    private static final char MULTIPLY_SYMBOL = '*';
    private static final char DIVIDE_SYMBOL = '/';

    private static final int EXPECTED_NUMBER_OF_COMMAND_FIELDS = 3;

    MathCommand command;
    double leftValue;
    double rightValue;
    double result;

    /**
     * @param statement is an input string of the form "command arg1 arg2"
     *                  Valid commands are:
     *                      "add": arg1 + arg2
     *                      "subtract": arg1 - arg2
     *                      "multiply": arg1 * arg2
     *                      "divide": arg1 / arg2
     *                  Commands are case-insensitive.
     * @throws InvalidStatementException
     */
    public void process(String statement) throws InvalidStatementException {
        // add 1.0 2.0
        String[] parts = statement.split(" ");
        if(parts.length != EXPECTED_NUMBER_OF_COMMAND_FIELDS){
            throw new InvalidStatementException("Invalid Statement - Incorrect number of fields (expects " + EXPECTED_NUMBER_OF_COMMAND_FIELDS + ")", '"' + statement + '"');
        }

        String commandString = parts[0]; // add

        try {
            leftValue = Double.parseDouble(parts[1]); // 1.0
            rightValue = Double.parseDouble(parts[2]); // 2.0
        }
        catch (NumberFormatException e) {
            throw new InvalidStatementException("Invalid Statement - Non-numeric data", '"' + statement + '"', e);
        }

        setCommandFromString(commandString);
        if(command == null) {
            throw new InvalidStatementException("Invalid Statement - Invalid command", '"' + statement + '"');
        }

        CalculateBase calculator = null;
        switch(command){
            case Add:
                calculator = new Adder(leftValue, rightValue);
                break;
            case Subtract:
                calculator = new Subtracter(leftValue, rightValue);
                break;
            case Multiply:
                calculator = new Multiplier(leftValue, rightValue);
                break;
            case Divide:
                calculator = new Divider(leftValue, rightValue);
                break;
            default:
                // Invalid command
                // TODO Add error code here
        }

        calculator.calculate();
        result = calculator.result;
    }

    private void setCommandFromString(String commandString){
        // add -> MathCommand.Add

        if(commandString.equalsIgnoreCase(MathCommand.Add.toString())){
            command = MathCommand.Add;
        }
        else if (commandString.equalsIgnoreCase(MathCommand.Subtract.toString())){
            command = MathCommand.Subtract;
        }
        else if (commandString.equalsIgnoreCase(MathCommand.Multiply.toString())){
            command = MathCommand.Multiply;
        }
        else if (commandString.equalsIgnoreCase(MathCommand.Divide.toString())){
            command = MathCommand.Divide;
        }
    }

    @Override
    public String toString(){
        // Format we want: 1.0 + 2.0 = 3.0
        char symbol = ' ';
        switch (command){
            case Add:
                symbol = ADD_SYMBOL;
                break;
            case Subtract:
                symbol = SUBTRACT_SYMBOL;
                break;
            case Multiply:
                symbol = MULTIPLY_SYMBOL;
                break;
            case Divide:
                symbol = DIVIDE_SYMBOL;
                break;
            default:
                // Invalid item
                // TODO Error code here
        }

        String output;

//      String.format version
        output = String.format("%1$1.1f %2$c %3$1.1f = %4$1.1f", leftValue, symbol, rightValue, result);
        return output;

//        StringBuilder sb = new StringBuilder(20);
//        sb.append(leftValue);
//        sb.append(' ');
//        sb.append(symbol);
//        sb.append(' ');
//        sb.append(rightValue);
//        sb.append(" = ");
//        sb.append(result);
//
//        return sb.toString();

    }
}
