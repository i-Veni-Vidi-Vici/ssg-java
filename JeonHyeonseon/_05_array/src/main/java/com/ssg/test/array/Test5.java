package com.ssg.test.array;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {

        Test5 test5 = new Test5();
        test5.test5();
    }

    private void test5() {

        /**
         * - 배열의 크기로 홀수인 양의 정수를 입력 받아 배열을 만드세요.
         * - 배열의 중간까지는 1부터 1씩 증가하여 오름차순으로 값을 넣고,
         * - 중간 이후부터 끝까지는 1씩 감소하여 내림차순으로 값을 넣어 출력하는 프로그램을 작성하세요.
         */

        // 입력 받은 수의 길이가 홀수여야 한다.
        // 홀수를 입력 받아야 하기에 if ~ else 문 사용하기

        Scanner sc = new Scanner(System.in);
        System.out.print("홀수인 양의 정수를 하나 입력하세요 ==> ");
        int num = sc.nextInt();

        int[] arr = new int[num];

        if(num % 2 == 1) {  // 입력한 값이 홀수라면
            int mid = num / 2;   // 인덱스가 입력받은 수의 가운데 수
            for(int i = 0; i < arr.length; i++){
                if(i < mid) {
                    arr[i] = i + 1;
                } else {
                    arr[i] = num -1;
                }
            }
            System.out.print("[");
            for(int i = 0; i < arr.length; i++){
                System.out.print(arr[i]);
                System.out.print(i != arr.length - 1 ? ", " : "");
            }
            System.out.print("]");
        }
        else {
            System.out.println("잘못 입력했습니다. 홀수가 아닙니다.");
        }
    }
}
