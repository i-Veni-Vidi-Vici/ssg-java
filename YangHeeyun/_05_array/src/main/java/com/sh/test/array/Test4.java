package com.sh.test.array;

import java.util.Scanner;

/**
 *요구사항
 * 사용자의 전화번호를 입력 받고, 11자리의 문자형 배열에 저장한 후, 가운데 4자리를 *로 가리기
 * 출력예시
 * 전화번호 입력 : 01012345678
 * 출력 : 010****5678
 */
public class Test4 {
    public static void main(String[] args) {
        Test4 t = new Test4();
        t.test();
    }

    public void test(){
        Scanner sc = new Scanner(System.in);

        System.out.print("전화번호 입력 : ");
        String phone = sc.next();

        String[] arr = new String[phone.length()];

        for(int i=0;i<arr.length;i++){
            if(i>2 && i<7) arr[i] = "*" ;
            //else arr[i] = String.valueOf(phone.charAt(i));
            else arr[i] = String.valueOf(phone.charAt(i));
        }
        System.out.print("출력 : ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
    }
}
