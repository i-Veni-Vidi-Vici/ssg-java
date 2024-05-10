package com.sh._01.lifecycle;

/**
 * ..... 상황에서 xxxxx하면, +++++++++작동해야 한다 +~한다 = 단정문!!, Assertion
 *
 *
 */
public class App1 {
    public static void main(String[] args) {

    }
    public int getNumber() {
        return 32;
    }

    public int sum(int a, int b)
    {
        return a+b;
    }

    public int random() {
        return (int)(Math.random()*100)+100;
    }
}