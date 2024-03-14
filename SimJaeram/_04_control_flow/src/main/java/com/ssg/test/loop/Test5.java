package com.ssg.test.loop;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        // 회원정보 입력
        Scanner sc = new Scanner(System.in);

        System.out.println("회원1의 이름 입력 : ");
        String name1 = sc.next();
        System.out.println("회원1의 나이 입력 : ");
        int age1 = sc.nextInt();
        System.out.println("회원1의 주소 입력 : ");
        String address1 = sc.nextLine();
        System.out.println("회원1의 키 입력 : ");
        double height1 = sc.nextDouble();
        System.out.println("회원1의 몸무게 입력 : ");
        double weight1 = sc.nextDouble();
        System.out.println("회원1의 연락처 입력 : ");
        String phone1 = sc.nextLine();

        System.out.println("회원2의 이름 입력 : ");
        String name2 = sc.next();
        System.out.println("회원2의 나이 입력 : ");
        int age2 = sc.nextInt();
        System.out.println("회원2의 주소 입력 : ");
        String address2 = sc.nextLine();
        System.out.println("회원2의 키 입력 : ");
        double height2 = sc.nextDouble();
        System.out.println("회원2의 몸무게 입력 : ");
        double weight2 = sc.nextDouble();
        System.out.println("회원2의 연락처 입력 : ");
        String phone2 = sc.nextLine();

        System.out.println("회원3의 이름 입력 : ");
        String name3 = sc.next();
        System.out.println("회원3의 나이 입력 : ");
        int age3 = sc.nextInt();
        System.out.println("회원3의 주소 입력 : ");
        String address3 = sc.nextLine();
        System.out.println("회원3의 키 입력 : ");
        double height3 = sc.nextDouble();
        System.out.println("회원3의 몸무게 입력 : ");
        double weight3 = sc.nextDouble();
        System.out.println("회원3의 연락처 입력 : ");
        String phone3 = sc.nextLine();

        // 평균 나이, 키, 몸무게 계산
        int ageAvg = (age1 + age2 + age3) / 3;
        int heightAvg = (int) ((height1 + height2 + height3) / 3);
        int weightAvg = (int) ((weight1 + weight2 + weight3) / 3);

        // 회원정보 출력
        System.out.println("=================== 회원목록 ====================");
        System.out.printf("1 %s %d세 %s %fcm %fkg %s", name1, age1, address1, height1, weight1, phone1);
        System.out.printf("1 %s %d세 %s %fcm %fkg %s", name2, age2, address2, height2, weight2, phone2);
        System.out.printf("1 %s %d세 %s %fcm %fkg %s", name3, age3, address3, height3, weight3, phone3);
        System.out.println("=================================================");
        System.out.printf("평균나이 %d세 / 평균 키 : %dCM / 평균 몸무게 : %dkg", ageAvg, heightAvg, weightAvg);
    }
}
