package com.sh._enum._02.basics;

import javax.swing.text.html.CSS;

/**
 * enum은 Object를 상속하는게 아니라 extends Enum 상속(선언 할 수는 없음)
 * 모든 enum 클래스는 Enum을 암묵적으로 상속
 * -> name(), ordinal(), values() 등을 선언없이 사용 가능
 * 다른 클래스를 상속할 수 없음(인터페이스 구현은 가능)
 */

public enum SubjectType {
    JAVA,
    MYSQL,
    HTML, // 다음에 메소드 선언시 세미콜론 필수
    CSS,
    JAVASCRIPT;

    /**
     * 생성자를 명시적으로 선언 가능
     * 생성자의 접근제한자는 private이어서 외부에서 호출은 불가능
     * 런타임에 enum 객체가 생성되지 않고, 컴파일타임에 모두 결정됨
     * @return
     */
    SubjectType(){}
    public String toLowerCase(){
        // 상수 인스턴스를 this로 접근 가능
        return this.name().toLowerCase();
    }
}
