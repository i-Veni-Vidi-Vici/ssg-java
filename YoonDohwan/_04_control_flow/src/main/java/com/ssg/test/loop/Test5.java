package com.ssg.test.loop;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] name = new String[3];
        int[] age = new int[3];
        String[] adr = new String[3];
        int[] height = new int[3];
        int[] kg = new int[3];
        String[] call = new String[3];
        System.out.println("===============회원목록==================");
        for(int i=0;i<3;i++) {
            System.out.println("이름을 입력하시오 : ");
            name[i] = sc.nextLine();
            System.out.println("나이를 입력하시오 : ");
            age[i] = sc.nextInt();
            sc.nextLine();
            System.out.println("주소를 입력하시오 : ");
            adr[i] = sc.nextLine();
            System.out.println("키를 입력하시오 : ");
            height[i] = sc.nextInt();
            sc.nextLine();
            System.out.println("몸무게를 입력하시오 : ");
            kg[i] = sc.nextInt();
            sc.nextLine();
            System.out.println("연락처를 입력하시오 : ");
            call[i] = sc.nextLine();
        }
        for(int j=0;j<3;j++) {
             System.out.println((j+1)+" "+name[j]+" "+age[j]+" "+adr[j]+" "+height[j]+"cm "+kg[j]+"kg "+call[j]);
        }
        int avgage = (age[0]+age[1]+age[2])/3;
        int avgheight = (height[0]+height[1]+height[2])/3;
        int avgkg = (kg[0]+kg[1]+kg[2])/3;
        System.out.println("===============================================");
        System.out.println("평균나이 : "+avgage+"세/ "+"평균 키 : "+avgheight+"cm/"+"평균 몸무게 : "+avgkg+"kg");
    }
}
