package com.pluralsight.myapp;

import com.pluralsight.calcengine.DynamicHelper;
import com.pluralsight.calcengine.InvalidStatementException;
import com.pluralsight.calcengine.Divider;
import com.pluralsight.calcengine.Adder;
import com.pluralsight.calcengine.MathProcessing;
import com.pluralsight.calcengine.PowerOf;
import com.pluralsight.calcengine.Subtracter;
import com.pluralsight.calcengine.Multiplier;

public class Main {

    public static void main(String[] args) {

        String[] statements ={
                "add 1.0",
                "add xx 25.0",
                "addX 1.0 2.0",
                "add 25.0 92.0",    // 25 + 92 = 117
                "subtract 225.0 17.0",
                "multiply 11.0 3.0",
                "divide 100.0 50.0",
                "power 5.0 2.0"     // 5.0 ^ 2.0 = 25
        };

        DynamicHelper helper = new DynamicHelper(new MathProcessing[] {
                new Adder(),
                new Subtracter(),
                new Multiplier(),
                new Divider(),
                new PowerOf()
        });

        for(String statement:statements){
            try {
                String output = helper.process(statement);
                System.out.println(output);
            } catch (InvalidStatementException e){
                System.out.println(e.getMessage());
                if(e.getCause() != null){
                    System.out.println("    Original exception: "
                            + e.getCause().getMessage());
                }
            }
        }

    }

}
