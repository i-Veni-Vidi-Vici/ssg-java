package com.sh._enum._03.advance;

import javax.swing.*;
import java.util.Scanner;

/**
 * <pre>
 *
 * </pre>
 */
public class App1 {
    public static void main(String[] args) {
        DevType dev1=DevType.WEB;
        DevType dev2=DevType.IOS;
        DevType dev3=DevType.ANDROID;

        System.out.println(dev1);
        System.out.println(dev2);
        System.out.println(dev3);

        System.out.println("WEB(1234) : "+dev1.getCode());
        System.out.println(dev2.getCode());//3333
        System.out.println(dev3.getCode());//7777

        //DevType.valueOf(name:String)
        // "WEB" -> DevType.WEB
        DevType dev4=DevType.valueOf(1234);
        //DevType dev4=DevType.valueOf("WEadasdasdaB"); //이건 빨간불 나온다
        System.out.println("1234 : "+dev4);

        //1234-> DevType.WEB
        DevType num=DevType.valueOf(1234);
        System.out.println(num);

        // 사용자 입력을 Member객체를 생성한다
        // 사용자 입력값 문자열이다
//        Scanner sc = new Scanner(System.in);
//        System.out.println("아이디를 입력하세요");
//        String name=sc.nextLine();
//        System.out.println("이름를 입력하세요");
//        String id=sc.nextLine();
//        System.out.println("당신의 개발 직종을 선택하세요. WEB/IOS/ANDROID");
//        String type=sc.nextLine();
//        DevType devType=DevType.valueOf(type);
//        Dev dev=new Dev(id,name,devType);
//        System.out.println(dev.toString());

        //UserRole.valueOf(String) 이미 슈펴클래스에 있기 떄문에
        // 따로 만들어줘야 한다
        UserRole userRole1=UserRole.of("사용자");
        UserRole userRole2=UserRole.of("관리자");
        UserRole userRole3=UserRole.of("슈퍼관리자");

        System.out.println(userRole1);
        System.out.println(userRole2);
        System.out.println(userRole3);



    }
}
