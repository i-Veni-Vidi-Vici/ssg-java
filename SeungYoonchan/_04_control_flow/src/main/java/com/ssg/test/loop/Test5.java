package com.ssg.test.loop;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 회원 정보 입력 받기
        Member member1 = inputInfo(scanner, 1);
        Member member2 = inputInfo(scanner, 2);
        Member member3 = inputInfo(scanner, 3);

        // 평균 연령, 평균 키, 평균 몸무게 계산
        int avgAge = (int)((member1.age + member2.age + member3.age) / 3.0);
        int avgHeight = (int)((member1.height + member2.height + member3.height) / 3.0);
        int avgWeight = (int)((member1.weight + member2.weight + member3.weight) / 3.0);

        // 회원 정보 출력
        System.out.println("=================== 회원목록 ================");
        printInfo(member1);
        printInfo(member2);
        printInfo(member3);
        System.out.println("===========================================");
        // 평균값 출력
        System.out.println("\n평균 연령: " + avgAge + "평균 키: " + avgHeight + "평균 몸무게: " + avgWeight);
    }

    public static Member inputInfo(Scanner scanner, int num) {
        System.out.println("\n" + num + "번째 회원 정보를 입력하세요:");
        System.out.print("이름: ");
        String name = scanner.nextLine();
        System.out.print("나이: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("주소: ");
        String address = scanner.nextLine();
        System.out.print("키(cm): ");
        double height = Double.parseDouble(scanner.nextLine());
        System.out.print("몸무게(kg): ");
        double weight = Double.parseDouble(scanner.nextLine());
        System.out.print("연락처: ");
        String contact = scanner.nextLine();

        return new Member(name, age, address, height, weight, contact);
    }

    public static void printInfo(Member member) {
        System.out.println(member.name + member.age + member.address + member.height + member.weight + member.phoneNumber);
    }
}

class Member {
    String name;
    int age;
    String address;
    double height;
    double weight;
    String phoneNumber;

    public Member(String name, int age, String address, double height, double weight, String contact) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.height = height;
        this.weight = weight;
        this.phoneNumber = contact;
    }
}
