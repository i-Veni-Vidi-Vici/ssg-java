package com.sh.loop.test.loop;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        //홍길동 / 19세 / 서울시 강남구 / 170cm / 68kg / 01012345678
        System.out.printf("이름 나이 주소 키 몸무게 전화번호\n");

        String h1_name=sc.next();
        String h1_age=sc.next();
        String h1_address=sc.next();
        String h1_height=sc.next();
        String h1_weight=sc.next();
        String h1_num=sc.nextLine();


        System.out.printf("이름%s 나이%s 주소%s 키%s 몸무게%s 번호%s ",
                h1_name,h1_age,h1_address,h1_height,h1_weight,h1_num);


    }
}
