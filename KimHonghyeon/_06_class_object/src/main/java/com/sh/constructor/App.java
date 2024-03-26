package com.sh.constructor;

import java.time.LocalDate;

/**
 * 생성자 메소드
 * - 객체생성시 호출되는 메소드
 *      -생성자 함수는 new 연산자와 함께 호출되어야 한다.
 */
public class App {
    public static void main(String[] args) {
        //기본생성자
        User user1 = new User();
        user1.printUser();

        //필드 생성자
        User user2 = new User(0L, "김홍현", LocalDate.now());
        user2.printUser();

        //복사생성자
        User user3 = new User(user2);
        user3.printUser();
    }
}
