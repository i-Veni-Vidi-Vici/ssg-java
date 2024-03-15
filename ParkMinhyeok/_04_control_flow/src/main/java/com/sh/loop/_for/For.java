package com.sh.loop._for;

import java.util.Scanner;

public class For {
    public void test() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }
    }

    /**
     * 1 ~ 10까지 합 구하기
     */
    public void test4() {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
    // 1부터 난수까지의 합
    public  void test5() {
        int n = (int) (Math.random() * 5) + 6;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println("n: " + n);
        System.out.println("sum: " + sum);
    }
    /**
     * 사용자로부터 입력받은 단수(2 ~ 9)의 구구단 출력
     * - 숫자입력 : 7
     * - 7단 출력
     */
    public void test6() {
        Scanner scanner = new Scanner(System.in);
        int inputNum = scanner.nextInt();
        for (int i = 1; i <= 9; i++) {
//            System.out.println(inputNum + " * " + i + " = " + (inputNum * i));
            System.out.printf("%d * %d = %d \n", inputNum, i, inputNum * i);
        }
    }
}
