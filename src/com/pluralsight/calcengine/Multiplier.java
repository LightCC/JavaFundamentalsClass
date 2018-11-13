package com.pluralsight.calcengine;

public class Multiplier extends CalculateBase implements MathProcessing {
    public Multiplier() {
    }

    public Multiplier(double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }

    @Override
    public void calculate() {
        result = leftVal * rightVal;
    }

    @Override
    public String getKeyword() {
        return "multiply";
    }

    @Override
    public char getSymbol() {
        return '*';
    }
}
