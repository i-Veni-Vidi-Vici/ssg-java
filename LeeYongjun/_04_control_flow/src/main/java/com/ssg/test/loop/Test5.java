package com.ssg.test.loop;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("이름은 : ");
        String name1 = sc.next();

        System.out.println("이름은 : ");
        String name2 = sc.next();

        System.out.print("이름은 : ");
        String name3 = sc.next();


        System.out.print("나이는 : ");
        int age1 = sc.nextInt();

        System.out.print("나이는 : ");
        int age2 = sc.nextInt();


        System.out.print("나이는 : ");
        int age3 = sc.nextInt();

        System.out.println("주소는 : ");
        String address1 = sc.next();

        System.out.println("주소는 : ");
        String address2 = sc.next();

        System.out.println("주소는 : ");
        String address3 = sc.next();

        System.out.print("키는 : ");
        int height1 = sc.nextInt();

        System.out.print("키는 : ");
        int height2 = sc.nextInt();

        System.out.print("키는 : ");
        int height3 = sc.nextInt();

        System.out.print("몸무게는 : ");
        int weight1 = sc.nextInt();

        System.out.print("몸무게는 : ");
        int weight2 = sc.nextInt();

        System.out.print("몸무게는 : ");
        int weight3 = sc.nextInt();

        System.out.print("전화번호는 : ");
        String phonenum1 = sc.next();

        System.out.print("전화번호는 : ");
        String phonenum2 = sc.next();

        System.out.print("전화번호는 : ");
        String phonenum3 = sc.next();

        int avgage = 0;
        int avgheight = 0;
        int avgweight = 0;
        for(int i = 1; i <= 3; i++){
            System.out.print("이름은 : ");
            System.out.print("나이는 : ");
            System.out.print("주소는 : ");
            System.out.print("몸무게는 : ");
            System.out.print("전화번호는 : ");

        }
        avgage = (age1 + age2 + age3)/3;
        avgheight = (height1 + height2 + height3)/3;
        avgweight = (weight1 + weight2 + weight3)/3;
        System.out.println("=================== 회원목록 ===================");
        System.out.println("1 " + name1 + " " + age1 + " " + address1 + " " + weight1 + " " + phonenum1);
        System.out.println("2 " + name2 + " " + age2 + " " + address2 + " " + weight2 + " " + phonenum2);
        System.out.println("3 " + name3 + " " + age3 + " " + address3 + " " + weight3 + " " + phonenum3);
        System.out.println("=================================================");
        System.out.println("평균나이 " + avgage + " 평균 키 " + avgheight + " 평균 몸무게 " + avgweight);
    }
}
