package com.ssg.test.loop;

import java.lang.reflect.Member;
import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = new String[3];
        int[] ages = new int[3];
        String[] address = new String[3];
        int[] height = new int[3];
        int[] weight = new int[3];
        String[] phoneNumber = new String[3];

        int avgAge = 0;
        int avgHeight = 0;
        int avgWeight = 0;

        for(int i = 0; i<3; i++)
        {
            System.out.print((i+1)+". 이름을 입력하세요 : ");
            names[i] = scanner.nextLine();

            System.out.print((i+1) +". 나이를 입력하세요 : ");
            ages[i] = scanner.nextInt();
            scanner.nextLine();

            System.out.print((i+1)+". 주소를 입력하세요 : ");
            address[i] = scanner.nextLine();

            System.out.print((i+1) + ". 키를 입력하세요 : ");
            height[i] = scanner.nextInt();
            scanner.nextLine();

            System.out.print((i+1)+". 몸무게를 입력하세요 : ");
            weight[i] = scanner.nextInt();
            scanner.nextLine();

            System.out.print((i+1) +". 번호를 입력하세요 : ");
            phoneNumber[i] = scanner.nextLine();
        }
        int totalAge = 0;
        int totalHeight = 0;
        int totalWeight = 0;
        for(int i = 0; i<1;i++ )
        {
           totalAge += ages[i];
           avgAge = totalAge / 3;

           totalHeight += height[i];
           avgHeight = totalHeight / 3;

           totalWeight += weight[i];
           avgWeight = totalWeight / 3;

        }

        System.out.println("============회원 목록 ===================");
        for(int i = 0; i<3; i++)
        {
            System.out.println((i + 1)+". " + names[i] + " " + address[i] + " " +
                                height[i]+"CM"+ " " + weight[i]+"kg"+ " " + phoneNumber[i]);
        }
        System.out.println("=======================================");
        System.out.println("평균나이 : " + avgAge + "평균 키 : " + avgHeight + "평균 몸무게 : " + avgWeight);


    }


    }

