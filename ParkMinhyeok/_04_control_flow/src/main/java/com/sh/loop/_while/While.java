package com.sh.loop._while;

import java.util.Scanner;

public class While {
    public void test1() {
        // 1~ 10 출력
//        int i = 1;
//        while (i <= 10) {
//            System.out.println(i);
//            i++;
//        }
        int i = 2;
        while (i <= 20) {
            System.out.println(i);
            i+= 2;
        }
    }

    /**
     * 1 ~ 10 누적합 구하기
     */
    public void test2() {
        int sum = 0;
        int i = 1;
        while (i <= 10) {
            sum += i;
            i++;
        }
        System.out.println(sum);
    }
    public void test3() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("아무말이나 하세요...");
        String str = scanner.nextLine();
        int i = 0;

        while (i < str.length()) {
            char ch = str.charAt(i);
            System.out.println(i + " : " + ch);
            i++;
        }
    }
    public void test4() {
        int i = 2;
        while (i <= 9) {
            int j = 1;
            while (j <= 9) {
                System.out.printf("%d * %d = %d\n", i, j, i * j);
                j++;
            }
            i++;
        }
    }
}
