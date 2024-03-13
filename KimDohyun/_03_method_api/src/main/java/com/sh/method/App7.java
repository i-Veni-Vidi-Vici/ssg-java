package com.sh.method;

public class App7 {
    public static void main(String[] args) {
        App7 app = new App7();
        int a = 5;
        int b = 8;
        int diff = app.minus(a,b);
        System.out.print(diff);
    }

    public int minus(int a, int b){
        return a-b;
    }
}

