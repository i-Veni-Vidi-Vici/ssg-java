package com.ssg.test.loop;

public class Test7 {
    public static void main(String[] args) {

        String n = "";

        for(int i = 1; i <= 9; i++) {
            for(int j = 1; j <= i; j++) {
//                System.out.print(j);
                System.out.printf("%s * 8 + %d = %d\n" , j, i, (j * 8 + i) );
            }

            System.out.println();
        }
    }
}
