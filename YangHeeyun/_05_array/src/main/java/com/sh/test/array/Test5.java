package com.sh.test.array;

import java.util.Scanner;

/**
 * 요구사항 :
 * - 배열의 크기로 홀수인 양의 정수를 입력 받아 배열을 만드세요.
 * - 배열의 중간까지는 1부터 1씩 증가하여 오름차순으로 값을 넣고,
 * - 중간 이후부터 끝까지는 1씩 감소하여 내림차순으로 값을 넣어 출력하는 프로그램을 작성하세요.
 *
 * 출력예시
 * 홀수인 양의정수를 하나 입력하세요 ==> 7
 * [1, 2, 3, 4, 3, 2, 1]
 * 홀수인 양의정수를 하나 입력하세요 ==> 6
 * 잘못 입력했습니다. 홀수가 아닙니다.
 */

public class Test5 {
    public static void main(String[] args) {
        Test5 t = new Test5();
        t.test();
    }

    public void test(){
        Scanner sc = new Scanner(System.in);

        System.out.print("홀수인 양의정수를 하나 입력하세요 ==> ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        int half = n/2;
        int val=1;

        if(n%2==1){
            for(int i=0;i<arr.length;i++){
                if(i<half){
                    arr[i] = val++;
                }else{
                    arr[i] = val--;
                }
            }
            System.out.print("[");
            for(int i=0;i<arr.length;i++){
                if(i==arr.length-1) System.out.print(arr[i]+"]");
                else System.out.print(arr[i]+", ");
            }
        }else{
            System.out.println("잘못 입력했습니다. 홀수가 아닙니다.");
        }
    }
//              배열형태로 출력하기
//            System.out.print("[");
//            for (int i = 0; i < intArr.length; i++) {
//            System.out.print(intArr[i]);
//            System.out.print(i != intArr.length - 1 ? ", " : "");
//            }
//            System.out.print("]");
}


