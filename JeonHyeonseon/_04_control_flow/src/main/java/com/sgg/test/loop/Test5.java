package com.sgg.test.loop;

import java.util.Scanner;

public class Test5 {
    /**
     * - 3명의 회원정보를 입력 받아 저장하고 출력하는 프로그램을 만드세요.
     * - 입력값 : 이름, 나이, 주소, 키, 몸무게, 연락처
     * - 마지막에 평균나이, 평균키, 평균 몸무게 출력하세요.
     * - 평균계산에 필요한 변수를 만들어 사용할수 있습니다.
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = "";
        int age = 0;
        String address = "";
        int height = 0;
        int weight = 0;
        String phoneNum = "";

        int memberCnt = 2;  // 반복문 길이

        // 총합
        int sumAge = 0;
        int sumHeight = 0;
        int sumWeight = 0;

        // 평균
        double avgAge = 0;
        double avgHeight = 0;
        double avgWeight = 0;

        String result = ("============== 회원목록 ===============");
        for (int i = 1; i <= memberCnt; i ++) {
            System.out.print("이름을 입력하세요");
            name = sc.next();

            System.out.print("나이를 입력하세요");
            age = sc.nextInt();

            sc.nextLine();
            System.out.print("주소를 입력세요");
            address = sc.nextLine();

            System.out.print("키(cm)를 입력하세요");
            height = sc.nextInt();

            System.out.print("몸무게(kg)를 입력하세요");
            weight = sc.nextInt();

            System.out.print("전화번호를 입력하세요");
            phoneNum = sc.next();

            result += (i + 1) + "\t" + name + "\t" + age + "\t" + address + "\t" + height + "\t" + weight + "\t" + phoneNum + "\n";

            // 총합/평균 구하기
            sumAge += age;
            sumHeight += height;
            sumWeight += weight;
        }

        // 평균나이
        avgAge = (double) sumAge / memberCnt;
        // 평균 키
        avgHeight = (double) sumHeight / memberCnt;
        // 평균 몸무게
        avgWeight = (double) sumWeight / memberCnt;

        System.out.println("==================================");
        System.out.printf("평균 나이 %.1f세 / 평균 키 : %.1fcm / 평균 몸무게 : %.1fkg", avgAge, avgHeight, avgWeight);

    }
}
