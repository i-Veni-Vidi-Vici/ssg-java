package com.sh._enum._03.advanced;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        DevType dev1 = DevType.WEB;
        DevType dev2 = DevType.IOS;
        DevType dev3 = DevType.ANDROID;

        System.out.println(dev1);
        System.out.println(dev2);
        System.out.println(dev3);
        System.out.println();
        System.out.println(dev1.getCode());
        System.out.println(dev2.getCode());
        System.out.println(dev3.getCode());


        //DevType.valueOf(name : String)
        //"WEB" -> DevType.WEB으로 변경하고싶으면
        DevType dev4 = DevType.valueOf("WEB");
        System.out.println(dev4);
        System.out.println(dev4.getCode());
        DevType dev5 = DevType.valueOf(1234);
        System.out.println(dev5);

        //사용자 입력으로 Meber 객체를 생성한다.
        //사용자 입력값 문자열이다.
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("아이디 : ");
//        int id = scanner.nextInt();
//        System.out.println("이름");
//        String name=  scanner.next();
//        System.out.println("개발직종을 선택하세요 ~ WEB / IOS / Android : ");
//        String type = scanner.next();
//        DevType devType = DevType.valueOf(type);
//        Dev dev = new Dev(id, name, devType);
//        System.out.println(dev);

        //UserRole.valueOf(String)
        UserRole userRole = UserRole.valueOf("USER");
        UserRole userRole2 = UserRole.of("사용자");
        System.out.println(userRole2);
        System.out.println(userRole);
    }
}
