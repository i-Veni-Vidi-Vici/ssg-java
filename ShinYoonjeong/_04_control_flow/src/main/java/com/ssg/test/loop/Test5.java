package com.ssg.test.loop;

import java.util.Scanner;

public class Test5 {
    public void test(){
        Scanner sc = new Scanner(System.in);
        int height=0;
        int age=0;
        int weight=0;
        String name;
        int num = 0;
        double a=0,h=0,w=0;
        String address = null;
        for(int i=0;i<3;i++){
            System.out.println("이름 : ");
            name = sc.nextLine();
            System.out.println("나이 : ");
            age = sc.nextInt();
            System.out.println("주소 : ");
            name = sc.nextLine();
            System.out.println("키 : ");
            height = sc.nextInt();
            System.out.println("몸무게 : ");
            weight = sc.nextInt();
            System.out.println("연락처 : ");
            num = sc.nextInt();
            a+=age;h+=height;w+=weight;
            System.out.println(name + age + address + height + weight + num);
        }
        System.out.println("평균 나이 : " + a/3 + "세" + "평균 키 : " + h/3 + "cm" + "평균 몸무게 : " + w/3 + "kg");

    }
}
