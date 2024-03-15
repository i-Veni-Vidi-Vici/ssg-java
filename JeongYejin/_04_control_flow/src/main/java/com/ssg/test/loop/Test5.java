package com.ssg.test.loop;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Test5 test5 = new Test5();
        test5.test();
    }

    public void test() {
        int sumAge = 0;
        int sumHeight = 0;
        int sumWeight = 0;
        String list = "";
        for (int i=1; i<=3; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.print("이름을 입력하세요 : ");
            String name = sc.nextLine();
            System.out.print("나이를 입력하세요 : ");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.print("주소를 입력하세요 : ");
            String address = sc.nextLine();
            System.out.print("키를 입력하세요 : ");
            int height = sc.nextInt();
            System.out.print("몸무게를 입력하세요 : ");
            int weight = sc.nextInt();
            sc.nextLine();
            System.out.print("연락처를 입력하세요 : ");
            String phoneNum = sc.nextLine();

            sumAge += age;
            sumHeight += height;
            sumWeight += weight;
            list += (i + " " + name + " " + age + "세 " + " " + address + " " + height + "cm " + weight + "kg " + phoneNum);
            if (i < 3) {
                System.out.println();
            }
        }

        System.out.println("=========회원목록==========");
        System.out.println(list);
        System.out.println("==========================");
        System.out.printf("평균나이 %d세 / 평균 키 : %dcm / 평균 몸무게 : %dkg", sumAge/3, sumHeight/3, sumWeight/3);
    }
}
