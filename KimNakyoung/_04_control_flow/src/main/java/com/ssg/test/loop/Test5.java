package com.ssg.test.loop;

import java.util.Scanner;

/**
 * - 3명의 회원정보를 입력 받아 저장하고 출력하는
 * 프로그램을 만드세요.
 * - 입력값 : **이름, 나이, 주소, 키, 몸무게, 연락처**
 * - 마지막에 평균나이, 평균키, 평균몸무게 출력하세요.
 * - 평균계산에 필요한 변수를 만들어 사용할수 있습니다.
 *
 */
public class Test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 회원 정보를 저장할 배열 선언
        String[] userNames = new String[3];
        int[] userAges = new int[3];
        String[] userAddresses = new String[3];
        int[] userHeights = new int[3];
        int[] userWeights = new int[3];
        String[] userNums = new String[3];


        int sumAge = 0; // 나이 총합
        int sumHeight = 0; // 키 총합
        int sumWeight = 0; // 몸무게 총합

        // 배열이 0부터 시작이라서  초기화를 0으로 해줘야함
        for (int i = 0; i < 3; i++) {
            System.out.println(i+1 + "번째 " + "회원이름 입력해주세요(3명): ");
            userNames[i] = sc.nextLine();

            System.out.println(i+1 + "번째 " + "회원나이 숫자만 입력해주세요(3명): ");
            userAges[i] = sc.nextInt();
            sumAge += userAges[i];
            sc.nextLine();// 개행문자 버리기

            System.out.println(i+1 + "번째 " + "회원주소 입력해주세요(3명): ");
            userAddresses[i] = sc.nextLine();

            System.out.println(i+1 + "번째 " + "회원키 입력해주세요(3명): ");
            userHeights[i] = sc.nextInt();
            sumHeight += userHeights[i];

            System.out.println(i+1 + "번째 " + "회원몸무게 입력해주세요(3명): ");
            userWeights[i] = sc.nextInt();
            sumWeight += userWeights[i];
            sc.nextLine(); // 개행문자 버리기

            System.out.println(i+1 + "번째 " + "회원연락처 입력해주세요(3명): ");
            userNums[i] = sc.nextLine();

        }
        System.out.println("===========회원목록=========================");
        for (int i = 0; i < 3; i++) {
            System.out.printf("%d %s %d세 %s %dcm %dkg %s\n", i+1, userNames[i], userAges[i], userAddresses[i], userHeights[i], userWeights[i], userNums[i]);

        }
        System.out.println("==========================================");
        System.out.printf("평균나이 %.2f세 / 평균 키 : %.2fCM / 평균 몸무게 : %.2fkg", (double) sumAge / 3.0, (double) sumHeight / 3.0, (double) sumWeight / 3.0);
    }
}
