package com.ssg.test.loop;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 회원1 정보 입력
        System.out.println("회원1 회원정보");
        System.out.print("이름입력 : ");
        String name1 = sc.next();
        System.out.print("나이입력 : ");
        int age1 = sc.nextInt();
        sc.nextLine();
        System.out.print("주소입력 : ");
        String address1 = sc.nextLine();
        System.out.print("키입력 : ");
        int height1 = sc.nextInt();
        System.out.print("몸무게입력 : ");
        int weight1 = sc.nextInt();
        System.out.print("연락처입력 : ");
        String phNum1 = sc.next();
        // 회원2 정보 입력
        System.out.println("회원2 회원정보");
        System.out.print("이름입력 : ");
        String name2 = sc.next();
        System.out.print("나이입력 : ");
        int age2 = sc.nextInt();
        sc.nextLine();
        System.out.print("주소입력 : ");
        String address2 = sc.nextLine();
        System.out.print("키입력 : ");
        int height2 = sc.nextInt();
        System.out.print("몸무게입력 : ");
        int weight2 = sc.nextInt();
        System.out.print("연락처입력 : ");
        String phNum2 = sc.next();
        // 회원3 정보 입력
        System.out.println("회원3 회원정보");
        System.out.print("이름입력 : ");
        String name3 = sc.next();
        System.out.print("나이입력 : ");
        int age3 = sc.nextInt();
        sc.nextLine();
        System.out.print("주소입력 : ");
        String address3 = sc.nextLine();
        System.out.print("키입력 : ");
        int height3 = sc.nextInt();
        System.out.print("몸무게입력 : ");
        int weight3 = sc.nextInt();
        System.out.print("연락처입력 : ");
        String phNum3 = sc.next();

        // 회원목록 작성
        System.out.println("==================회원목록==================");
        System.out.println("1 " + name1 + " " + age1 + "세 " + address1 + " " + height1 + "cm " + weight1 + "kg " + phNum1);
        System.out.println("2 " + name2 + " " + age2 + "세 " + address2 + " " + height2 + "cm " + weight2 + "kg " + phNum2);
        System.out.println("3 " + name3 + " " + age3 + "세 " + address3 + " " + height3 + "cm " + weight3 + "kg " + phNum3);
        System.out.println("==========================================");

        int meanAge     = (age1 + age2 + age3) / 3;
        int meanHeight  = (height1 + height2 + height3) / 3;
        int meanWeight  = (weight1 + weight2 + weight3) / 3;

        System.out.println("평균나이 " + meanAge + "세 / 평균 키 : " + meanHeight + "CM / 평균 몸무게 : " + meanWeight + "kg");

    }
}
