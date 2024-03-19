package com.ssg.test.loop;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name;
        int age;
        String address;
        int height;
        int weight;
        String phoneNumber;

        int ageSum = 0;
        int heightSum = 0;
        int weightSum = 0;

        System.out.println("==================회원 목록==================");

        for (int i = 1; i <=3; i++) {

            System.out.print("이름 : ");
            name = sc.next();

            System.out.print("나이 : ");
            age = sc.nextInt();
            ageSum += age;

            System.out.print("주소 : ");
            sc.nextLine();
            address = sc.nextLine();

            System.out.print("키 : ");
            height = sc.nextInt();
            heightSum += height;

            System.out.print("몸무게 : ");
            weight = sc.nextInt();
            weightSum += weight;

            System.out.print("연락처 : ");
            phoneNumber = sc.next();

            System.out.println(i + " " + name + " " + age + "세 " + address + " " + height + "cm " + weight + "kg " + phoneNumber);
        }
        System.out.println("=========================================");
        System.out.println("평균 나이 : " + ageSum/3 + "세 / 평균 키 : " + heightSum/3 + "cm / 평균 몸무게 : " + weightSum/3 + "kg");

    }
}
