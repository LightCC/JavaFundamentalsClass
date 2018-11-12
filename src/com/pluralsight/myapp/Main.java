package com.pluralsight.myapp;

import com.pluralsight.calcengine.DynamicHelper;
import com.pluralsight.calcengine.InvalidStatementException;
import com.pluralsight.calcengine.CalculateHelper;
import com.pluralsight.calcengine.CalculateBase;
import com.pluralsight.calcengine.Divider;
import com.pluralsight.calcengine.Adder;
import com.pluralsight.calcengine.MathProcessing;
import com.pluralsight.calcengine.PowerOf;
import com.pluralsight.calcengine.Subtracter;
import com.pluralsight.calcengine.Multiplier;

public class Main {

    public static void main(String[] args) {
//        useCalculatorBase();

        String[] statements ={
                "add 25.0 92.0",    // 25 + 92 = 117
                "power 5.0 2.0"     // 5.0 ^ 2.0 = 25
        };

        DynamicHelper helper = new DynamicHelper(new MathProcessing[] {
                new Adder(),
                new PowerOf()
        });

        for(String statement:statements){
            String output = helper.process(statement);
            System.out.println(output);
        }

//        static void useCalculateHelper(){
//            String[] statements = {
//                    "add 1.0",
//                    "add xx 25.0",
//                    "addX 1.0 2.0",
//                    "divide 100.0 50.0",    // 100.0 / 50.0 = 2.0
//                    "add 25.0 92.0",        // 25.0 + 92.0 = 117.0
//                    "subtract 225.0 17.0",  // 225.0 - 17.0 = 108.0
//                    "multiply 11.0 3.0",    // 11.0 * 3.0 = 33.0
//            };
//
//            CalculateHelper helper = new CalculateHelper();
//            for(String statement:statements){
//                try{
//                    helper.process(statement);
//                    System.out.println(helper);
//                } catch (InvalidStatementException e){
//                    System.out.println(e.getMessage());
//                    if(e.getCause() != null){
//                        System.out.println("    Original exception: " + e.getCause().getMessage());
//                    }
//                }
//            }
//        }

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
