package com.sh.constructor;

import java.time.LocalDate;

/**
 * <pre>
 * 생성자 메소드
 * - 객체 생성시 호출되는 메소드
 *   - 생성자 함수는 new 연산자와 함께 호출되어야 함
 *   - 생성자 함수명은 클래스명과 동일해야 함
 *   - (명시적인) 리턴 타입 없음 (생성된 객체의 주소값을 반환하긴 함)
 * - 객체 생성시 필드들의 초기화 담당
 * - 기본 생성자는 작성하지 않아도 compiler에 의해 자동 생성
 * - 단, 필드생성자를 작성하는 경우에는 기본 생성자를 명시적으로 작성해야함
 * </pre>
 */

public class App {
    public static void main(String[] args) {
        // 객체 생성 레시피
        // 클래스명(타입) 변수명 = new 생성자(); // new 클래스(); (X)
        User user = new User();

        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getCreatAt());

        // 필드 생성자를 통한 객체 생성
        User user2 = new User(2, "신사임당", LocalDate.of(2024,3,18));

        System.out.println(user2.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getCreatAt());

        User user21 = new User(3, "이순신"); // 모든 필드 다 써야 하는 건 아님
        System.out.println(user21.getId());
        System.out.println(user21.getName());
        System.out.println(user21.getCreatAt());

        // 복사 생성자를 통한 객체 생성
        // - 객체 속성값이 동일한 객체를 복제하는 경우 : 객체 다름(주소값 다름)
        User user3 = new User(user2);
        System.out.println(user3.getId());
        System.out.println(user3.getName());
        System.out.println(user3.getCreatAt());

        System.out.println(user2.hashCode()); // 1324119927
        System.out.println(user3.hashCode()); // 990368553
    }
}
