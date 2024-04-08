package com.sh._enum._02.basics;

/**
 * <pre>
 * 모든 enum클래스는 Enum을 암묵적으로 상속한다
 * - name(), ordinal(), values() 등을 선언 없이 사용할 수 있다.
 * - 다른 클래스를 상속할 수는 없다. (인터페이스 구현은 가능)
 * </pre>
 */
public enum SubjectType {
    // 필드만 있으면 상관없는데 아래 메소드 같은데 있으면
    // 끝났다는 의미로 ; 찍어줘야 한다
    JAVA, HTML, MYSQL, JAVASCRIPT, CSS;

    /**
     * 생성자를 명시적으로 선언할 수 있다. 생성자의 접근제한자는 private이어서 외부에서 호출 불가
     * - 런타임에 enum객체가 생성되지 않고, 컴파일타임에 모두 결정되는 것이다
     * - //extends Enum 메소드가 없는데 잇지?? 그럼 상속받은거다 근데 직접 쓸 수 는 없다
     *
     * @return
     */
    public String toLowerCase(){
        // 선언된 상수 하나 하나를 this 로 접근한다
        return this.name().toLowerCase();
    }

}
