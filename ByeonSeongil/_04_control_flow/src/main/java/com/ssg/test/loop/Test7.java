package com.ssg.test.loop;

public class Test7 {
    public static void main(String[] args) {
        int sum = 0;

        for (int i = 1; i <= 9; i++) {
            sum = sum*10 +i;
            System.out.printf("%9d x %d + %d = %d\n", sum, 8, i, sum*8+i);
        }
    }
}
