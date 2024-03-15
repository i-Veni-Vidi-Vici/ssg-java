package com.ssg.test.loop;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Test5 test5 = new Test5();
        test5.test();
    }

    public void test() {
        Scanner sc = new Scanner(System.in);
        String name = "";    // 이름
        int age = 0;    // 나이
        String address = ""; // 주소
        int height = 0; // 키
        int weight = 0; // 몸무게
        String phone = "";    // 연락처
        int cnt = 0;    // 회원 수
        String result = ""; // 입력한 정보 출력
        int sumAge = 0; // 3명의 나이 합
        int sumHeight = 0;   // 3명의 키 합
        int sumWeight = 0;   // 3명의 몸무게 합

        for(int i=0; i<3; i++) {
            System.out.println("---------회원" + (i+1) + " 정보---------");
            System.out.print("이름을 입력하세요: ");
            name = sc.next();
            System.out.print("나이를 입력하세요: ");
            age = sc.nextInt();
            System.out.print("주소를 입력하세요: ");
            address = sc.next();
            sc.nextLine();
            System.out.print("키를 입력하세요: ");
            height = sc.nextInt();
            System.out.print("몸무게를 입력하세요: ");
            weight = sc.nextInt();
            System.out.print("연락처를 입력하세요: ");
            phone = sc.next();
            System.out.println();

            result += (i+1) + " " + name + " " + age + "세 " + address + " " + height + "cm " + weight + "kg " + phone + "\n";

            sumAge += age;
            sumHeight += height;
            sumWeight += weight;
            cnt++;
        }

        System.out.println("================== 회원목록 ===================");
        System.out.print(result);
        System.out.println("==============================================");
        int avgAge = sumAge / cnt;
        int avgHeight = sumHeight / cnt;
        int avgWeight = sumWeight / cnt;
        System.out.printf("평균나이 %d세 / 평균 키 : %dCM / 평균 몸무게 : %dkg\n", avgAge, avgHeight, avgWeight);
    }
}