package com.sh._enum._02.basics;

/**
 * 모든 enum 클래스는 Enum을 암묵적으로 상속한다.
 * - name(), ordinal(), values()등을 선언없이 사용할 수 있다.
 * - 다른 클래스를 상속할 수는 없다. (인터페이스 구현은 가능)
 */
public enum SubjectType /*extends Enum*/ {
    JAVA,
    MYSQL,
    HTML,
    CSS,
    JAVASCRIPT;
    // 상수값만 있다면 ; 안 찍어도 되는데 밑에 메소드 쓸거면 써주세요

    /**
     * <pre>
     * 생성자를 명시적으로 선언할 수 있다. 생성자의 접근제한자는 private이어서 외부에서 호출은 불가능하다.
     * - 런타임에 enum객체가 생성되지 않고 컴파일타임에 모두 결정된다.
     * </pre>
     */
    SubjectType(){

    }

    public String toLowerCase(){
        // 상수인스턴스를 this로 접근할 수 있다.
        // this.name():String
        return this.name().toLowerCase();
    }
}
