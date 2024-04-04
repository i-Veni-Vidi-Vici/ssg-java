package com.sh._enum._02.basics;

/**
 * 생성자를 명시적으로 선언할 수 있다. 생성자의 접근제한자는 private 이어서 외부에서 호출 불가능하다.
 *  - 렅타임에 enum 객체가 생성되지 않고 컴파일타임에 모두 결정되는 것이다.
 * 모든 enum 클래스는 Enum 을 암묵적으로 상속한다.
 *  - name(),ordinal(), values() 등을 선언 없이 사용 가능
 *  - 다른 클래스는 상속할 수 없다.(인터페이스는 구현 가능)
 */
public enum SubjectType {
    JAVA,
    MYSQL,
    HTML,
    CSS,
    JAVASCRIPT;

    SubjectType() {

    }

    public String toLowerCase() {
        return this.name().toLowerCase();
    }
}
