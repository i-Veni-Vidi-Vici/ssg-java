package com.ssg.test.array;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("홀수인 양의 정수 입력 : ");
        int userNum = sc.nextInt();

        if (userNum %2 == 0) { // 입력한 수가 짝수 일 때 실행X
            System.out.println("잘못 입력했어요! 홀수가 아닙니다!");
            return;
        }

        int [] oddArray = new int[userNum];
        int stepNum = 1;

        for (int i = 0; i < oddArray.length; i++) {
            if(stepNum <= oddArray.length/2 +1) {
                oddArray[i] = stepNum + i;
            }
            else{
                oddArray[i] = stepNum - 1;
            }
        }

        System.out.print("[");
        for (int j = 0; j<oddArray.length; j++) {
            if(j!=0) {
                System.out.print(", ");
            }
            System.out.print(oddArray[j]);
        }
        System.out.print("]");

    }
}
