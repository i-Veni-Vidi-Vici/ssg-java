package com.sh.constructor;

import java.time.LocalDate;

/**
 * <pre>
 *     생성자 메소드
 *     - 객체 생성시 딱 한번만 자동으로 호출되는 메소드
 *      - 생성자 메소드는 new 연산자와 함께 호출되어야 한다.
 *      - 생성자 메소드의 이름은 클래스의 이름과 동일하다.
 *      - 리턴타입이 없다. (사실은 생성된 객체의 주소값을 반환)
 *     - 객체 생성시 필드들의 초기화 담당
 *     - 기본 생성자는 개발자가 별도로 작성하지 않아도, 컴파일러에 의해서 자동으로 생성된다.
 *     - 단, 필드 생성자를 작성하는 경우에는 기본 생성자를 컴파일러가 자동으로 작성해주지 않아, 기본생성자를 개발자가 명시적으로 작성해야 한다.
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // 객체 생성
        // 클래스명 변수명 = new 클래스명();
        // 클래스(타입) 변수명 = new 생성자명();
        User user = new User();

        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getCreatedAt());

        // 필드 생성자를 통한 객체 생성
        User user2 = new User(2, "신사임당", LocalDate.of(2024, 3, 18));
        System.out.println(user2.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getCreatedAt());

        User user21 = new User(3, "신사임당");
        System.out.println(user21.getId());
        System.out.println(user21.getName());
        System.out.println(user21.getCreatedAt());

        //  복사 생성자를 톻한 객체 생성
        // - 객체 속성 값이 동일한 객체를 복제하는 경우
        User user3 = new User(user2);
        System.out.println(user3.getId());
        System.out.println(user3.getName());
        System.out.println(user3.getCreatedAt());

        // 해시 코드는 객체에 대한 식별값
        System.out.println(user2.hashCode());
        System.out.println(user3.hashCode());
    }
}
