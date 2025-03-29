package com.sh._enum._03.advanced;

public class App {
    public static void main(String[] args) {
        DevType dev1 = DevType.WEB;
        DevType dev2 = DevType.IOS;
        DevType dev3 = DevType.ANDROID;

        System.out.println(dev1);
        System.out.println(dev2);
        System.out.println(dev3);
        
        // code를 확인
        System.out.println(dev1.getCode()); // 1234
        System.out.println(dev2.getCode()); // 3333
        System.out.println(dev3.getCode()); // 7777

        // DevType.valueOf(name: String)
        // "WEB" -> DevType.WEB
        DevType dev4 = DevType.valueOf("WEB");
//        DevType dev4 = DevType.valueOf("WEEEEEEBBBBBBB"); // java.lang.IllegalArgumentException: No enum constant com.sh._enum._03.advanced.DevType.WEEEEEEBBBBBBB
        System.out.println(dev4);
        // 1234 -> DevType.WEB
        DevType dev5 = DevType.valueOf(1234);
        System.out.println(dev5);

        // 사용자 입력을 Member객체를 생성한다.
        // 사용자 입력값 문자열이다.
//        Scanner sc = new Scanner(System.in);
//        System.out.println("아이디를 입력하세요 : ");
//        String id = sc.next();
//        System.out.println("이름을 입력하세요 : ");
//        String name = sc.next();
//        System.out.println("당신의 개발직종을 선택하세요~ WEB/IOS/ANDROID : ");
//        String type = sc.next();
//        DevType devType = DevType.valueOf(type);
//        Dev dev = new Dev(id, name, devType);
//        System.out.println(dev);

        // UserRole.valueOf(String)
        UserRole userRole1 = UserRole.valueOf("USER");
        UserRole userRole2 = UserRole.of("사용자");
        System.out.println(userRole1);
        System.out.println(userRole2);
    }
}
