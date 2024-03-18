package com.ssg.test.loop;

public class Test7 {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++){
            String a = "";
            for (int j = 1; j <= i; j++){
                a += String.valueOf(j);
            }
            String b = " ".repeat(9 - i);
            System.out.printf("%s%s x 8 + %d = %d\n", b, a, i, (Integer.parseInt(a) * 8 + i));
        }
    }
}
