package com.sh.constructor;

import java.time.LocalDate;

/**
 * <pre>
 *  생성자메소드
 *  - 객체생성시 호출되는 메소드
 *      - 생성자함수는 new 연산자와 함께 호출되어야 한다.
 *      - 생성자함수명은 클래스명과 동일한다!!!!!
 *      - 리턴타입 없다!!!!!!!! (사실 생성된 객체의 주솟값 반환하긴함)
 *  - 객체생성시 필드들의 초기화 담당.
 *  - 기본생성자는 작성하지 않아도 compiler에 의해 자동으로 생성
 *  - 단, 필드생성자를 작성하는 경우에는 기본생성자를 명시적으로 작성해야 한다.
 *
 * </pre>
 *
 */


public class App {
    public static void main(String[] args) {
            // 객체 생성 레시피
            // 클래스(타입) 변수명 = new 생성자();
        User user = new User(); // 이거 밖에 없지만 호출이 됨
        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getCreatedAt());

        //필드 생성자를 통한 객체 생성
        //이거 실행할 땐 기본 생성자 일 안했음
        User user2 = new User(2,"심사임당", LocalDate.of(2024,3,18));
        System.out.println(user2.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getCreatedAt());

        // 복사 생성자를 통한 객체 생성
        // 객체속성값이 동일한 객체를 복제하는 경우
        User user3 = new User(user2); // new 할 때 마다 힙영역에 새롭게 만들어짐
        System.out.println(user3.getId());
        System.out.println(user3.getName());
        System.out.println(user3.getCreatedAt());

        User user21 = new User(3,"이순신"); // new 할 때 마다 힙영역에 새롭게 만들어짐
        System.out.println(user21.getId());
        System.out.println(user21.getName());
        System.out.println(user21.getCreatedAt());

    }
}
