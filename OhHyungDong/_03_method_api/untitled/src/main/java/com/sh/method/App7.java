package com.sh.method;

/**
 * <pre>
 *
 * </pre>
 */
public class App7 {

    public static void main(String[] args) {
        App7 app = new App7();

        int a = 30;
        int b = 20;

        int sum =app.plus(a,b);
        System.out.println("합 = " + sum);

        int diff = app.minus(a,b);
        System.out.println("diff = " + diff);

        int product = app.multiply(a,b); //곱
        System.out.println("product = " + product);

        int quotient = app.divide(a,b);
        System.out.println("quotient = " + quotient);

        int remainder = app.mod(a,b);
        System.out.println("remainder = " + remainder);


    }
    public int plus(int a, int b)
    {
        return a+b;
    }
     public int minus(int a, int b)
    {
        return a-b;
    }
     public int multiply(int a, int b)
    {
        return a *b;
    }
     public int divide(int a, int b)
    {
        return a/b;
    }

    public int mod(int a, int b)
    {
        return a%b;
    }


}
