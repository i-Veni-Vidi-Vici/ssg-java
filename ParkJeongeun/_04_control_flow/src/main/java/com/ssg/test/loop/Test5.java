package com.ssg.test.loop;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name ="";
        int age = 0;
        String address ="";
        int h = 0;
        int w = 0;
        String m = "";

        int sumAge = 0;
        int sumh = 0;
        int sumw = 0;

//        for (int i = 0; i < 3; i++){
//            System.out.print("> 이름 입력 : ");
//            name = sc.nextLine();
//            System.out.print("> 나이 입력 : ");
//            age = sc.nextInt();
//            sumAge += age;
//            sc.nextLine();
//            System.out.print("> 주소 입력 : ");
//            address = sc.nextLine();
//            System.out.print("> 키 입력 (cm) : ");
//            h = sc.nextInt();
//            sumh += h;
//            System.out.print("> 몸무게 입력 (kg) : ");
//            w = sc.nextInt();
//            sumh += w;
//            sc.nextLine();
//            System.out.print("> 연락처 입력 : ");
//            m = sc.nextLine();
//        }

        double avgAge = sumAge / 3.0;
        double avgh = sumh / 3.0;
        double avgw = sumw / 3.0;

        System.out.println("> 이름, 나이, 주소, 키, 몸무게, 연락처 순으로 입력하세요.");
        System.out.println("=====================회원목록=====================");
        for (int i = 1; i <=3; i++) {
            System.out.print(i + " ");
            name = sc.nextLine();
            age = sc.nextInt();
            System.out.println("세");

            address = sc.nextLine();
            h = sc.nextInt();
            w = sc.nextInt();
            sc.nextLine();
            m = sc.nextLine();

        }
        System.out.println("=================================================");
        System.out.printf("평균 나이 : %f세 / 평균 키 : %fcm / 평균 몸무게 : %fkg", avgAge, avgh, avgw);
    }
}
