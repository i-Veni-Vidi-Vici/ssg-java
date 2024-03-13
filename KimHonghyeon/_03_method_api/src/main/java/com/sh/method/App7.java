package com.sh.method;

public class App7 {
    public static void main(String[] args) {
        App7 app = new App7();
        int a = 30;
        int b = 20;
        int sum = app.plus(a,b);
        System.out.println("sum = " + sum);
        int diff = app.diff(a,b);
        System.out.println("diff = " + diff);
        int product = app.product(a,b);
        System.out.println("product = " + product);
        int quotient = app.quotient(a,b);
        System.out.println("quotient = " + quotient);
        int mod = app.mod(a,b);
        System.out.println("mod = " + mod);
    }
    public int plus(int a, int b){return a+b;}
    public int diff(int a, int b){return a-b;}
    public int product(int a, int b){return a*b;}
    public int quotient(int a, int b){return a/b;}
    public int mod(int a, int b){return a%b;}
}
