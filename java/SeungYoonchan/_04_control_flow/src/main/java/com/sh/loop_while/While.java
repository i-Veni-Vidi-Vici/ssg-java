package com.sh.loop_while;


import java.util.Scanner;

public class While {
    public void test1(){
        int i = 0;

        while (i <= 10) {
            System.out.println(i);
            i++;
        }
    }
    public void test2(){
        int i = 0;
        int sum = 0;
        while (i <= 10) {
            sum = sum + i;
            i++;
        }
        System.out.println(sum);
    }

    public void test3(){
        Scanner sc = new Scanner(System.in);
        System.out.print("String typing : ");
        String str = sc.nextLine();
        int i = 0;
        while (i < str.length()) {
            char ch = str.charAt(i);
            System.out.println(i + " : " + ch);
            i++;
        }
    }


    public void test4() {
        int i = 2, j = 1;

        while (i <= 9) {
            j = 1;
            System.out.printf("%d단\n", i);
            while (j <= 9) {
                System.out.printf("%d * %d = %d\n", i, j, i * j);
                j++;
            }
            System.out.println();
            i++;
        }


    }
}
