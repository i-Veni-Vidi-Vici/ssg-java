package com.ssg.test.array;

import java.util.Scanner;

/**
 *
 * 사용자의 전화번호를 입력 받고, 11자리의 문자형 배열에 저장한 후, 가운데 4자리를 *로 가리기.
 */


public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("전화번호 입력 : ");
        String number = sc.nextLine();

        // 전화번호 배열 할당
        char[] n = new char[number.length()];

        //문자열에 입력받은 번호 각각 배열에 넣기
        for (int i = 0; i < number.length(); i++) {
            n[i] = number.charAt(i);
        }

        // 가운데 4자리 *로 가리기
        for (int j = 3; j <=6 ; j++) {
            n[j] = '*';
        }
//        System.out.println(n); 이렇게 출력해도 나옴 왜냐면 char 배열만 가능
        System.out.print("출력 : ");
        for (int i = 0; i < n.length; i++) {
            System.out.print(n[i]);
        }
    }
}
