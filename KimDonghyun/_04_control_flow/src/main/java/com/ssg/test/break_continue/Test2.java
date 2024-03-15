package com.ssg.test.break_continue;

import java.util.Scanner;

public class Test2 {
    /**
     * <pre>
     * 사용자로부터 정수를 두개 입력 받아서, 작은 정수에서 큰 정수까지 홀수의 합을 구하세요.
     * Tip. 큰수/작은수에 해당하는 변수를 사용할 것.
     *
     * 결과:
     * 정수를 하나 입력하세요. => 100
     * 다른 정수를 하나 입력하세요. => 1
     * ====================
     * 1부터 100까지의 홀수의 합은 2500입니다.
     * </pre>
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자1를 입력하세요.=> ");
        int num1 = sc.nextInt();
        System.out.print("숫자2를 입력하세요.=> ");
        int num2 = sc.nextInt();

        int sum = 0;
        int big = 0, small = 0;
        if (num1 > num2) {
            big = num1;
            small = num2;
        } else {
            big = num2;
            small = num1;
        }

        for (int i = small; i <= big; i++) {
            if (i % 2 == 0)
                continue;
            sum += i;
        }

        System.out.printf("%d부터 %d까지의 홀수의 합은 %d입니다.", small, big, sum);
    }
}
