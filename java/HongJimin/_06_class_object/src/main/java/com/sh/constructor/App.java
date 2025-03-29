package com.sh.constructor;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        // 객체 생성 레시피
        // 클래스(타입) 변수명 = new 생성자();
        User user = new User();

        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getCreatedAt());

        //필드 생성자를 통한 객체 생성
        User user2 = new User(2, "신사임당", LocalDate.of(2024, 3, 18));
        System.out.println(user2.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getCreatedAt());

        User user21 = new User(3, "이순신");
        System.out.println(user21.getId());
        System.out.println(user21.getName());
        System.out.println(user21.getCreatedAt());

        //복사 생성자를 통한 객체 생성
        // - 객체 속성값이 동일한 객체를 복제하는 경우
        User user3 = new User(user2);
        System.out.println(user3.getId());
        System.out.println(user3.getName());
        System.out.println(user3.getCreatedAt());

        System.out.println(user2.hashCode()); //1324119927
        System.out.println(user3.hashCode()); //990368553

    }
}
