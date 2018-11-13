package com.pluralsight.calcengine;

public class Subtracter extends CalculateBase implements MathProcessing {
    public Subtracter() {}

    public Subtracter(double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }

    @Override
    public void calculate() {
        result = leftVal - rightVal;
    }

    @Override
    public String getKeyword() {
        return "subtract";
    }

    @Override
    public char getSymbol() {
        return '-';
    }
}
