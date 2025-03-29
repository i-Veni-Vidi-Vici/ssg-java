package com.sh.constructor;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        User user = new User();

        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getCreateAt());

        // 필드 생성자를 통한 객체 생성
        User user2 = new User(2, "신사임당", LocalDate.of(2024, 3, 18));
        System.out.println(user2.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getCreateAt());


        User user3 = new User(user2);
        System.out.println(user3.getId());
        System.out.println(user3.getName());
        System.out.println(user3.getCreateAt());

        System.out.println(user2.hashCode());
        System.out.println(user3.hashCode());
    }
}
