package com.ssg.test.break_continue;

import java.util.Scanner;

/**
 * 1. 사용자로부터 정수를 두개 입력 받아서, 작은 정수에서 큰 정수까지 홀수의 합을 구하세요.
 *     - 큰수/작은수에 해당하는 변수를 사용
 * 2. 출력예시
 * 정수를 하나 입력하세요. => 100
 * 다른 정수를 하나 입력하세요. => 1
 * 1부터 100까지의 홀수의 합은 2500입니다.
 */

public class Test2 {
    public static void main(String[] args){
        Test2 t = new Test2();
        t.test();
    }

    public void test(){
        Scanner sc = new Scanner(System.in);

        System.out.print("정수를 하나 입력하세요. => ");
        int max = sc.nextInt();
        System.out.print("다른 정수를 하나 입력하세요. => ");
        int min = sc.nextInt();

        int plus = 0;

        for(int i = min ;i<=max;i++){
            if(i%2==0){
                continue;
            }
            plus += i;
        }
        System.out.printf("%d부터 %d까지의 홀수의 합은 %d입니다.",min,max,plus);
    }
}
