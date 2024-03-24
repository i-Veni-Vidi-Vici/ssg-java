package com.ssg.test.array;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {

        Test4 test = new Test4();
        test.test4();
    }

    private void test4() {

        // 사용자의 전화번호를 입력받고, 11자리의 문자형배열에 저장한후, 가운데 4자리를 *로 가리기.
        // 단, 원본 배열값은 변경 없이 배열 복사본으로 변경하세요

        // if문을 사용해서 인덱스 3 ~ 6까지 *로 표시하기

        Scanner sc = new Scanner(System.in);
        System.out.println("전화번호 입력 : ");
        String phoneNumber = sc.next();

        char[] number = new char[11];
        for(int i = 0; i < number.length; i++){
            if(i > 2 && i < 7) {
                number[i] = '*';
            } else {
                number[i] = phoneNumber.charAt(i);
            }
        }
        for(int i = 0; i < number.length; i++){
            System.out.print("출력 : " + number[i]);
        }
    }
}
