package com.ssg.test.loop;

import java.util.Scanner;

/**
 * - 요구사항 :
 *     - 정수를 입력 받아 1부터 입력 받은 정수까지 수를
 *     - 홀수와 짝수를 나눠서 홀수면 “수”, 짝수면 “박”을 출력 하세요.
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("정수입력 : ");
        int input = sc.nextInt();
        for(int i=1; i<=input; i++){
            if(i%2 == 1)
                System.out.print("수");
            else
                System.out.print("박");
        }
    }

}
