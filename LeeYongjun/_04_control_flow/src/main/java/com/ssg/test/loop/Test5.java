package com.ssg.test.loop;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = null;
        int age = 0;
        String address = null;
        int weight = 0;
        int height = 0;
        String phonenum = null;
        int avgage = 0;
        int avgheight = 0;
        int avgweight = 0;
        String result = null;
        for (int i = 1; i <= 3; i++) {
            System.out.print("이름은 : ");
            name = sc.next();
            System.out.print("나이는 : ");
            age = sc.nextInt();
            System.out.print("주소는 : ");
            address = sc.next();
            System.out.print("키는 : ");
            height = sc.nextInt();
            System.out.print("몸무게는 : ");
            weight = sc.nextInt();
            System.out.print("전화번호는 : ");
            phonenum = sc.next();

            result = (i + 1) + "\t" + name + "\t" + age + "\t" + address + "\t" + height + "cm\t" + weight + "kg\t"
                    + phonenum + "\n";
            avgage += age;
            avgheight += height;
            avgweight += weight;
        }
        System.out.println("=================== 회원목록 ====================");
        System.out.println(result);
        System.out.println("=================================================");
        System.out.println("평균나이 " + avgage / 3 + "세" + " 평균 키 " + avgheight / 3 + "cm" + " 평균 몸무게 " + avgweight / 3 + "kg");
    }
}
