package com.ssg.test.loop;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name, address, phone;
        String name1 = "", address1 = "", phone1 = "";
        String name2 = "", address2 = "", phone2 = "";
        String name3 = "", address3 = "", phone3 = "";
        int age, cm, kg;
        int age1 = 0, age2 = 0, age3 = 0;
        int cm1 = 0, cm2 = 0, cm3 = 0;
        int kg1 = 0, kg2 = 0, kg3 = 0;
        int i = 1;

        while(i <= 3){
            System.out.print("> " + i +"번째 이름 입력 : ");
            name = sc.next();
            System.out.print("> 나이 입력 : ");
            age = sc.nextInt();
            sc.nextLine();
            System.out.print("> 주소 입력 : ");
            address = sc.nextLine();
            System.out.print("> 키 입력 : ");
            cm = sc.nextInt();
            System.out.print("> 몸무게 입력 : ");
            kg = sc.nextInt();
            System.out.print("> 연락처 입력 : ");
            phone = sc.next();
            switch(i) {
                case 1: name1 = name; age1 = age; address1 = address; cm1 = cm; kg1 = kg; phone1 = phone; break;
                case 2: name2 = name; age2 = age; address2 = address; cm2 = cm; kg2 = kg; phone2 = phone; break;
                case 3: name3 = name; age3 = age; address3 = address; cm3 = cm; kg3 = kg; phone3 = phone; break;
            }

            System.out.println("정보 등록 완료!");
            System.out.println();
            i++;
        }
        System.out.println("=================== 회원목록 ====================");
        System.out.printf("1 %s %d세 %s %dcm %dkg %s\n", name1, age1, address1, cm1, kg1, phone1);
        System.out.printf("1 %s %d세 %s %dcm %dkg %s\n", name2, age2, address2, cm2, kg2, phone2);
        System.out.printf("1 %s %d세 %s %dcm %dkg %s\n", name3, age3, address3, cm3, kg3, phone3);
        System.out.println("=================================================");

        int avgAge = (age1 + age2 + age3) / 3;
        int avgCm = (cm1 + cm2 + cm3) / 3;
        int avgKg = (kg1 + kg2 + kg3) / 3;
        System.out.printf("평균나이 %d세 / 평균 키 : %dCM / 평균 몸무게 : %dkg", avgAge, avgCm, avgKg);
    }
}
