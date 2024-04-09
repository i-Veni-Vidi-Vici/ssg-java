package com.sh._enum._02.basics;

/**
 * 모든 enum클래스는 Enum을 암묵적으로 상속한다.
 * - name(), ordinal(), values()등을 선언 없이 사용할 수 있다.
 * - 다른 클래스를 상속할 수는 없다.(인터페이스 구현은 가능)
 */
public enum SubjectType {
    JAVA,
    MYSQL,
    HTML,
    CSS,
    JAVASCRIPT;
    //값만 있으면 ';'을 안찍어도 에러가 안나지만 추가 메소드가 있을 경우 ';'를 찍지 않으면 컴파일 오류 발생

    /**
     * <pre>
     *  생성자를 명시적으로 선어할 수 있다. 생성자의 생략된 접근제한자는 private이기 때문에 외부에서 호출은 불가능하다.
     *  - 런타임에 enum객체가 생성되지 않고, 컴파일 타임에 모두 결정되는 것이다.
     *  생성자가 있다고 해도 외부에서 호출 할 수 없다.(객체로 생성할 수 없다.)
     * </pre>
     * @return
     */

    public String toLowerCase(){
       return this.name().toLowerCase();
    }
}
