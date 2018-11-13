package com.pluralsight.calcengine;

public class PowerOf extends CalculateBase implements MathProcessing {
    public PowerOf(){}

    public PowerOf(double leftVal, double rightVal){
        super(leftVal, rightVal);
    }

    @Override
    public void calculate() {
        result = Math.pow(leftVal, rightVal);
    }

    @Override
    public String getKeyword() {
        return "power";
    }

    @Override
    public char getSymbol() {
        return '^';
    }
}
