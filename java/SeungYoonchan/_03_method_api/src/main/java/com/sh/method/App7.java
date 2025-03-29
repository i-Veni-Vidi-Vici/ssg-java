package com.sh.method;

public class App7 {
    public static void main(String[] args){

        App7 app = new App7();

        int a = 30;
        int b = 20;

        int sum = app.plus(a,b);
        int diff = app.minus(a,b);
        int product = app.multiply(a,b);
        int quotient = app.divide(a, b);
        int remainder = app.mod(a,b);

        System.out.println("합 : " + sum);
        System.out.println("차 : " + diff);
        System.out.println("곱 : " + product);
        System.out.println("몫 : " + quotient);
        System.out.println("나머지 : " + remainder);

    }
    public int mod(int a, int b) {return a%b;}
    public int divide(int a, int b) {return a/b;}
    public int multiply(int a, int b) {return a*b;}
    public int minus(int a, int b){return a-b;}
    public int plus(int a, int b){return a + b;}
}
