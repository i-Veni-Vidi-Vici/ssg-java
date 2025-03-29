package com.ssg.test.loop;

public class Test7 {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (j <= 9 - i) {
                    System.out.print(' ');
                }
                else {
                    System.out.print(j - (9 - i));
                }
            }
            System.out.print(" x 8 + " + i + " = ");
            for (int j = 9; j >= 1; j--) {
                if (j > 9 - i) {
                    System.out.print(j);
                }
            }
            System.out.println();
        }
    }
}
