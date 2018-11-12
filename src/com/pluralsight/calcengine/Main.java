package com.pluralsight.calcengine;

public class Main {

    public static void main(String[] args) {
        useMathEquations();
        useCalculatorBase();

    }

    static void useMathEquations(){
        //        MathEquation testEquation = new MathEquation('a');
        //        testEquation.execute();
        //        System.out.println("test = " + testEquation.getResult());

        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation('d',100.0d, 50.0d);
        equations[1] = new MathEquation('a',25.0d, 92.0d);
        equations[2] = new MathEquation('s',225.0d, 17.0d);
        equations[3] = new MathEquation('m',11.0d, 3.0d);

        for(MathEquation equation : equations) {
            equation.execute();
            System.out.println("result = " + equation.getResult());
        }

        System.out.println();
        System.out.println("Using Overloads");
        System.out.println();

        double leftDouble = 9.0d;
        double rightDouble = 4.0d;
        int leftInt = 9;
        int rightInt = 4;

        MathEquation equationOverload = new MathEquation('d');

        equationOverload.execute(leftDouble, rightDouble);
        System.out.println("double result = " + equationOverload.getResult());

        equationOverload.execute(leftInt, rightInt);
        System.out.println("int result = " + equationOverload.getResult());

        equationOverload.execute((double)leftInt, rightInt);
        System.out.println("double/int result = " + equationOverload.getResult());
    }

    static void useCalculatorBase(){
        System.out.println();
        System.out.println("Using Inheritance");
        System.out.println();

        CalculateBase[] calculators = {
                new Divider(100.0d, 50.0d),
                new Adder(25.0d, 92.0d),
                new Subtracter(225.0d, 17.0d),
                new Multiplier(11.0d, 3.0d)
        };

        for(CalculateBase calculator:calculators){
            calculator.calculate();
            System.out.println("result = " + calculator.getResult());
        }
    }
}
