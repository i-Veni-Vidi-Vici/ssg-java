package com.ssg.test.loop;

import java.util.Scanner;

/*
	3명의 회원정보를 입력 받아 저장하고 출력하는
	프로그램을 만드세요
	 입력 : 이름, 나이, 주소, 키, 몸무게, 연락처

	출력 예)
	================ 저장회원===============
	1 홍길동 19세 서울시 강남구 170cm 68kg 01012345678
	2 임걱정 20세 경기도 수원시 180cm 75kg 01012345678
	============================================
	평균나이 00세 / 평균 키 : 00CM / 평균 몸무게 : 00kg
                             .
 */

public class Test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name ="";
        int age =0;
        String address ="";
        int height =0;
        int weight=0;
        String phoneNum = "";

        int memCount = 3;



        //합, 평균
        int sumAge = 0;
        int sumHeight =0;
        int sumWeight = 0;

        double avgAge = 0;
        double avgHeight = 0;
        double avgWeight = 0;

        String info = "=========회원정보 저장==========\n";
        // 정보 입력
        for(int i=0;i<1;i++){
            System.out.print("이름 입력 : ");
            name = sc.next();
            System.out.print("나이 입력 : ");
            age = sc.nextInt();
            // 개행문자 뱉어내기 위한 nextLine
            sc.nextLine();
            System.out.print("주소 입력 : ");
            address = sc.nextLine();
            System.out.print("키 입력 : ");
            height = sc.nextInt();
            System.out.print("몸무게 입력 : ");
            weight = sc.nextInt();
            System.out.print("연락처 입력 : ");
            phoneNum = sc.next();


            info += name + "\t" + age + "세\t" + address + "\t" + height + "cm\t" + weight + "kg\t" + phoneNum+"\n";
            System.out.println(info);
        }





    }
}
