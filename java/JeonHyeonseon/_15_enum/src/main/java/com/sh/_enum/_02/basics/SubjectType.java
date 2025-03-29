package com.sh._enum._02.basics;

/**
 * <pre>
 * 모든 enum클래스는 Enum을 암묵적으로 상속한다.
 * - name(), ordinal(), values() 등을 선언 없이 사용할 수 있다.
 * - 다른 클래스를 상속할 수 없다.(인터페이스 구현은 가능)
 * </pre>
 */

public enum SubjectType /* extends Enum */ {  // enum 클래스 선언

    JAVA,
    MYSQL,
    HTML,
    CSS,
    JAVASCRIPT;

    /**
     * <pre>
     * 생성자를 명시적으로 선언할 수 있다. 생성자의 접근제한자는 private이기 때문에 외부에서 호출은 불가능하다.
     * - 런타임의 enum객체가 생성되지 않고, 컴파일 타입에 모두 결정되는 것이다.
     * </pre>
     * @return
     */
    SubjectType(){}

    // 메소드 선언할 때는 필드 마지막에 ;(세미콜론) 찍어야 한다.
    public String toLowerCase() {
        // 상수 인스턴스를 this로 접근할 수 있다.
        return this.name().toLowerCase(); // 현재 객체의 this : JAVA, MYSQL, HTML
    }

}
