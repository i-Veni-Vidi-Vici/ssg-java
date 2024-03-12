package com.sh.method;

/**
 * <pre>
 *
 * </pre>
 */
public class App7 {
    public static void main(String[] args) {
       App7 app7=new App7();
        int a = 30;
        int b = 20;
        int sum;

        sum=app7.sum(a,b);
        System.out.println("합계 = "+sum);

        int diff = app7.minus(a, b);
        System.out.println("차이 = "+diff);

        int product = app7.multiply(a, b);
        System.out.println("곱 = "+product);

        int quotient = app7.divide(a, b);
        System.out.println("몫 = "+quotient);

        int remainder = app7.mod(a, b);
        System.out.println("나머지 = "+remainder);
    }

    public int sum(int a, int b)
    {return a+b;}

    public int minus(int a,int b)
    {return a-b;}

    public int multiply(int a,int b)
    {return a*b;}

    public int divide(int a,int b)
    {return a/b;}

    public int mod(int a,int b)
    {return a%b;}
}
