package com.ssg.test.array;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        // 필요한 변수 선언
        Scanner sc = new Scanner(System.in);
        int arrLength = 0;
        int[] arr;

        // 배열의 크기 입력
        System.out.print("홀수인 양의 정수를 하나 입력하세요 ==> ");
        arrLength = sc.nextInt();

        // 사용자로 부터 입력 받은 값이 양의 정수가 아니면 안내 메세지 출력, 프로그램 종료
        if(arrLength <= 0 || arrLength % 2 == 0) {
            System.out.println("잘못 입력했습니다. 홀수가 아닙니다.");
            return;
        }

        // 배열 객체 생성
        arr = new int[arrLength];

        // 배열 요소에 값 대입
        // 배열의 크기 / 2 인덱스 기준으로 대입 값이 +1, -1
        int value = 1;
        int centerIndex = arrLength / 2;
        for(int i = 0; i < arr.length; i++) {
            arr[i] = value;
            if(i < centerIndex) {
                value++;
            } else {
                value--;
            }
        }

        // 배열 출력
        System.out.print("[");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if(i != arr.length - 1)
                System.out.print(", ");
        }
        System.out.print("]");
    }
}
