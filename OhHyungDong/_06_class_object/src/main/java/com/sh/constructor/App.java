package com.sh.constructor;

import java.time.LocalDate;

/**
 * <pre>
 *   생성자 메소드
 *
 *   - 객체 생성시 호출되는 메소드
 *      - 생성자 함수는 new 연산자와 함꼐 호출되어야 한다.
 *      - 생성자 함수명은 클래스명과 동일하다.
 *      - 리턴 타입이 없음. (사실은 생성된 객체의 주소값을 반환하지만 명시적인 리턴 타입은 없다.)
 *   - 객체 생성시 필드들의 초기화 담당.
 *   - 기본 생성자는 작성하지 않아도 compiler에 의해 자동으로 생성
 *   - 단, 필드 생성자를 작성하는 경우에는 기본 생성자를 명시적으로 작성해야 한다.
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        //객체 생성 레시피
        //클래스명(타입) 변수명 = new 클래스명(); => 클래스명 변수명 = new 생성자명();
        User user = new User();

        System.out.println(user.getId());


        //필드 생성자를 통한 객체 생성
        User user2 = new User(2,"신사임당", LocalDate.of(2023,3,18));
        System.out.println(user2.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getCreatedAt());

        //복사 생성자를 통한 객체 생성
//      //- 객체 속성값이 동일한 객체를 복제하느 ㄴ경우
        User user3 = new User(user2);
        System.out.println(user3.getId());
        System.out.println(user3.getName());
        System.out.println(user3.getCreatedAt());

        User user21 = new User(3,"이순신 ");
        System.out.println(user21.getId());
        System.out.println(user21.getName());
        System.out.println(user21.getCreatedAt());

    }
}
