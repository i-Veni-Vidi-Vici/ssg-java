package com.ssg.test.loop;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int height= 0;
        int weight= 0;
        int age =0;
        System.out.println("==============회원목록=============");
        for (int i = 0; i < 3; i++) {
            System.out.print(i+" ");
            String value = sc.next();
            age += Integer.parseInt(value.split(" ")[1].split("세")[0]);
            height += Integer.parseInt(value.split(" ")[4].split("cm")[0]);
            weight += Integer.parseInt(value.split(" ")[5].split("kg")[0]);
        }
        System.out.println("=================================");

        System.out.printf("평균나이 %d세 / 평균 키 %dcm / 평균 몸무게 %dkg", age/3,height/3,weight/3);
    }
}
