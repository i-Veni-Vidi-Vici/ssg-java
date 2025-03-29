package com.ssh.test.loop;

import java.util.Scanner;

public class Test5 {

    public static void main(String[] args) {
        String[] name = new String[3];
        int[] age = new int[3];
        String[] address = new String[3];
        int[] height = new int[3];
        int[] weight = new int[3];
        String[] contact = new String[3];

        double averageAge = 0;
        double averageHeight = 0;
        double averageWeight = 0;

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("- " + i + 1 + "번째 회원 정보 입력 -");
            System.out.print("이름 입력 : ");
            name[i] = sc.next();

            System.out.print("나이 입력 : ");
            age[i] = sc.nextInt();
            averageAge += age[i];
            sc.nextLine();      // 버퍼에 "\n" 비우기

            System.out.print("주소 입력 : ");
            address[i] = sc.nextLine();

            System.out.print("키 입력 : ");
            height[i] = sc.nextInt();
            averageHeight += height[i];

            System.out.print("몸무게 입력 : ");
            weight[i] = sc.nextInt();
            averageWeight += weight[i];

            System.out.print("연락처 입력 : ");
            contact[i] = sc.next();
            System.out.println();
        }

        System.out.println("=================== 회원목록 ====================");
        for (int i = 0; i < 3; i++) {
            System.out.printf("%d\t%s\t%d세\t\t%s\t%dcm\t%dkg\t%s\n",
                    i + 1, name[i], age[i], address[i], height[i], weight[i], contact[i]);
        }
        System.out.println("=================================================");
        System.out.printf("평균 나이 : %f세 / 평균 키 : %fCM / 평균 몸무게 : %fKG\n",
                averageAge / 3, averageHeight / 3, averageWeight / 3);
    }
}
