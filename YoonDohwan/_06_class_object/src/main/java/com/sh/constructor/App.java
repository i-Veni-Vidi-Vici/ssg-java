package com.sh.constructor;

import java.time.LocalDate;

/**
 * 생성자메소드
 * -객체생성시 호출되는 메소드
 * -생성자 함수는 new 연산자와 함께 호출되어야 한다.
 * -생성자함수명은 클래스명과 동일하다.
 * -리턴타입이 없다. (사실은 생성된 객체의 주소값을 반환)
 * -객체생성시 필드들의 초기화 담당.
 * -기본생성자는 작성하지 않아도 compiler에 의해서 자동으로 생성
 * -단,필드생성자를 작성하는 경우에는 기본생성자를 명시적으로 작성해야 한다.
 *
 */
public class App {
    public static void main(String[] args) {
      //객체 생성 레시피
        //클래스명(타입) 변수명 = new 생성자();
        User user = new User();
        User user2 = new User(2,"신사임당", LocalDate.of(2024,3,18));
        //복사 생성자를 통한 객체 생성
        //-객체 속성값이 동일한 객체를 복제하는 경우


    }
}
