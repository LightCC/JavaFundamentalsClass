package com.pluralsight.calcengine;

public class DynamicHelper {
    private MathProcessing[] handlers;

    public DynamicHelper(MathProcessing[] handlers) {
        this.handlers = handlers;
    }

    public String process(String statement){
        // IN: add 1.0 2.0
        // OUT: 1.0 + 2.0 = 3.0

        String[] parts = statement.split(MathProcessing.SEPARATOR);
        String keyword = parts[0]; // e.g. add

        MathProcessing theHandler = null;

        for (MathProcessing handler:handlers){
            if(keyword.equalsIgnoreCase(handler.getKeyword())){
                theHandler = handler;
                break;
            }
        }

        double leftVal = Double.parseDouble(parts[1]); // e.g. 1.0
        double rightVal = Double.parseDouble(parts[2]); // e.g. 2.0

        double result = theHandler.doCalculation(leftVal, rightVal);

        String output = String.format("%1$1.1f %2$c %3$1.1f = %4$1.1f", leftVal, theHandler.getSymbol(), rightVal, result);
        return output;
    }

}
