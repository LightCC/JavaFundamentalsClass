package com.pluralsight.calcengine;

public abstract class CalculateBase {
    protected double leftVal;
    protected double rightVal;
    protected double result;

//    public double getLeftVal() { return leftVal; }
//    public void setLeftVal(double leftVal) { this.leftVal = leftVal; }
//    public double getRightVal() { return rightVal; }
//    public void setRightVal(double rightVal) { this.rightVal = rightVal; }
//    public double getResult() { return result; }
//    public void setResult(double result) { this.result = result; }

    public CalculateBase(){}

    public CalculateBase(double leftVal, double rightVal) {
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }

    /** doCalculation accepts the two arguments for the mathematical
     *  calculation, then runs the calculate() method, which is abstract
     *  and must be implements in the helper classes.
     * @param leftVal Argument 1 of 2
     * @param rightVal Argument 2 of 2
     */
    public double doCalculation(double leftVal, double rightVal){
        this.leftVal = leftVal;
        this.rightVal = rightVal;

        calculate();
        return result;
    }

    public abstract void calculate();
}
