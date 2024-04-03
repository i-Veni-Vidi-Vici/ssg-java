package com.ssg.test.loop.loop_Re;

public class Test7 {
    public static void main(String[] args) {
        for(int i = 1; i < 10; i++) {
            String n = "";
            for(int j = 1; j <= i; j++){
                n += String.valueOf(j);
            }
//            System.out.println(n);
            String padding = " ".repeat(9 - i);
            System.out.printf("%s%s x 8 + %d = %s%n", padding, n, i, Integer.parseInt(n) * 8 + i);
        }
    }
}
