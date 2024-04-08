package com.sh._enum._03.advanced;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        DevType dev1 = DevType.WEB;
        DevType dev2 = DevType.IOS;
        DevType dev3 = DevType.ANDROID;

        System.out.println(dev1); // WEB
        System.out.println(dev2); // IOS
        System.out.println(dev3); // ANDROID

        // code 확인
        System.out.println(dev1.getCode()); // 1234
        System.out.println(dev2.getCode()); // 3333
        System.out.println(dev3.getCode());  // 7777

        // DevType.valueOf(name:String)
        // int 받는건 기본 세팅X -> 오버라이드
        DevType dev4 = DevType.valueOf("WEB");
//        DevType dev5 = DevType.valueOf("WEEB"); // 오타내면 X :Exception in thread "main" java.lang.IllegalArgumentException: No enum constant com.sh._enum._03.advanced.DevType.WEEB
        DevType dev5 = DevType.valueOf(1234);
        System.out.println(dev5); // WEB

        // valueOf 사용 예시
//        Scanner sc = new Scanner(System.in);
//        System.out.print("아이디 입력 : ");
//        String id = sc.next();
//        System.out.print("이름 입력 : ");
//        String name = sc.next();
//        System.out.print("당신의 개발직종을 선택하세요. WEB/IOS/ANDROID");
//        String type = sc.next();
//        DevType devType = DevType.valueOf(type);
//        Dev dev = new Dev(id, name, devType);
//        System.out.println(dev);

        // UserRole.valueOf(String)
//        UserRole userRole = UserRole.valueOf("사용자"); // UserRole에서 desc받는 valueOf 메소드 오버로딩 필요
        UserRole userRole1 = UserRole.valueOf("USER");
        UserRole userRole2 = UserRole.of("사용자");
        System.out.println(userRole1); // USER
        System.out.println(userRole2); // USER
    }
}
