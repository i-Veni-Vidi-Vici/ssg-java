package com.ssg.test.loop;

import java.util.Scanner;

/**
 * - 정수를 입력 받아 1부터 입력 받은 정수까지 수를
 * - 홀수와 짝수를 나눠서 홀수면 “수”, 짝수면 “박”을 출력 하세요..
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(">정수입력 : ");
        int num = sc.nextInt();
        String str = "";
        for (int i = 1; i <= num; i++){
            if (i %2 != 0){
                str += "수"; // 홀수

            }
            else {
                str += "박"; // 짝수
            }
        }System.out.println(str);

    }

}
