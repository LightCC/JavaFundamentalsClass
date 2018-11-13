package com.pluralsight.calcengine;

public class DynamicHelper {
    private static final int EXPECTED_NUMBER_OF_COMMAND_FIELDS = 3;

    private MathProcessing[] handlers;

    public DynamicHelper(MathProcessing[] handlers) {
        this.handlers = handlers;
    }

    public String process(String statement) throws InvalidStatementException {
        // IN: add 1.0 2.0
        // OUT: 1.0 + 2.0 = 3.0

        String[] parts = statement.split(MathProcessing.SEPARATOR);
        String keyword = parts[0]; // e.g. add

        if(parts.length != EXPECTED_NUMBER_OF_COMMAND_FIELDS){
            throw new InvalidStatementException(
                    "Invalid Statement - Incorrect number of fields (expects "
                    + EXPECTED_NUMBER_OF_COMMAND_FIELDS + ")",
                    '"' + statement + '"');
        }

        MathProcessing theHandler = null;

        for (MathProcessing handler:handlers){
            if(keyword.equalsIgnoreCase(handler.getKeyword())){
                theHandler = handler;
                break;
            }
        }
        if (theHandler == null){
            throw new InvalidStatementException(
                    "Invalid Statement - Invalid command",
                    '"' + statement + '"');
        }

        double leftVal, rightVal;
        try{
            leftVal = Double.parseDouble(parts[1]); // e.g. 1.0
            rightVal = Double.parseDouble(parts[2]); // e.g. 2.0
        }
        catch (NumberFormatException e) {
            throw new InvalidStatementException("Invalid Statement - Non-numeric data",
                    '"' + statement + '"', e);
        }

        double result = theHandler.doCalculation(leftVal, rightVal);

        return String.format("%1$1.1f %2$c %3$1.1f = %4$1.1f",
                leftVal, theHandler.getSymbol(), rightVal, result);
    }

}
