package com.ssg.test.array;
import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 사용자로부터 홀수인 양의 정수를 입력 받기.
        System.out.print("홀수인 양의 정수를 입력하세요 ==> ");
        int size = sc.nextInt();

        // 입력 값이 홀수가 아니면 오류 메시지를 출력 후 프로그램 종료.
        if (size % 2 == 0 || size <= 0) {
            System.out.println("잘못 입력했습니다. 홀수가 아닙니다.");
            return;
        }

        // 배열 생성 및 초기화
        int[] array = new int[size];
        int middle = size / 2;

        // 배열 값 설정
        for (int i = 0; i <= middle; i++) {
            array[i] = array[size - i - 1] = i + 1;
        }

        // 배열 출력
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i]);
            if (i != size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
