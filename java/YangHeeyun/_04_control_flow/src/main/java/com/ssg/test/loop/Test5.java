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
        Test5 t = new Test5();
        t.test();
    }
    private void test(){
        Scanner sc = new Scanner(System.in);

        String name ="";
        int age =0;
        String address ="";
        int height =0;
        int weight=0;
        String phoneNum = "";

        //합, 평균
        int sumAge = 0;
        int sumHeight =0;
        int sumWeight = 0;

        double avgAge = 0;
        double avgHeight = 0;
        double avgWeight = 0;

        String info = "=================== 회원목록 ========================\n";

        // 정보 입력
        for(int i=0;i<3;i++) {
            System.out.printf("==========%d번 회원정보 입력==================\n",i+1);
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


            info += (i + 1) + "\t" + name + "\t" + age + "세\t" + address + "\t" + height + "cm\t" + weight + "kg\t" + phoneNum + "\n";

            // 총합 & 평균 구하기
            sumAge += age;
            sumHeight += height;
            sumWeight += weight;

        }
        avgAge = sumAge/3;
        avgHeight = sumHeight/3;
        avgWeight = sumWeight/3;

        info += "===========================================================";
        System.out.println(info);
        System.out.printf("평균나이 : %.1f세 / 평균 키 : %.1fCM / 평균 몸무게 : %.1fkg",avgAge,avgHeight,avgWeight);
    }
}