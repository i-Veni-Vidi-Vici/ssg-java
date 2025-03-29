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
        int sumH = 0;
        int sumW = 0;

        String result = "=====================회원목록=====================\n";

        for (int i = 1; i <= 3; i++){
            System.out.print("> 이름 입력 : ");
            name = sc.nextLine();
            System.out.print("> 나이 입력 : ");
            age = sc.nextInt();
            sc.nextLine();
            System.out.print("> 주소 입력 : ");
            address = sc.nextLine();
            System.out.print("> 키 입력 (cm) : ");
            h = sc.nextInt();
            System.out.print("> 몸무게 입력 (kg) : ");
            w = sc.nextInt();
            sc.nextLine();
            System.out.print("> 연락처 입력 : ");
            m = sc.nextLine();

            result += i + "\t" + name + "\t" + age + "세\t" + address + "\t" + h + "cm\t" + w + "kg\t" + m + "\n";

            sumAge += age;
            sumH += h;
            sumW += w;
        }

        double avgAge = sumAge / 3.0;
        double avgH = sumH / 3.0;
        double avgW = sumW / 3.0;

        result += "=================================================\n";
        System.out.println(result);
        System.out.printf("평균 나이 : %.1f세 / 평균 키 : %.1fcm / 평균 몸무게 : %.1fkg", avgAge, avgH, avgW);
    }
}
