package com.pluralsight.calcengine;

public interface MathProcessing {
    String SEPARATOR = " ";
    String getKeyword(); // e.g. add
    char getSymbol(); // e.g. '+'
    double doCalculation(double leftVal, double rightVal);
}
