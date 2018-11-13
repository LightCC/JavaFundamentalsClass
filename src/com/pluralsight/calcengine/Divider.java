package com.pluralsight.calcengine;

public class Divider extends CalculateBase implements MathProcessing {
    public Divider() {}

    public Divider(double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }

    @Override
    public void calculate() {
        result = leftVal / rightVal;
    }

    @Override
    public String getKeyword() {
        return "divide";
    }

    @Override
    public char getSymbol() {
        return '/';
    }
}
