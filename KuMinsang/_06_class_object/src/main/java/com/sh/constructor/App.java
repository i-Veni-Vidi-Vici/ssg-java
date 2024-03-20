package com.sh.constructor;

import java.time.LocalDate;

/**<pre>
 * 생성자 메소드
 * - 객체 생성시 호출되는 메소드
 *  - 생성자 함수는 new 연사자와 함께 호출되어야 한다
 *  - 생성자 함수 명은 클래스 명과 일해야한다
 *  - 리턴 타입이 없다.(생성된 객체의 주소값을 반환)
 * - 객체 생성시 필드의 초기화 담당
 * - 기본 생성자는 작성하지 않아도 compiler에 자동으로 생성됨
 * - 단, 필드 생성자를 작성하는 경우에는 기본 생성자를 명시적으로 작성해야 한다
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        User user = new User(998, "김춘삼", LocalDate.now());
        System.out.println(user.hashCode());
        user.userInfo();

        User user2 = new User(user);
        System.out.println(user2.hashCode());
        user2.userInfo();

        User user3 = new User(202, "박춘배");
        user3.userInfo();

    }
}
