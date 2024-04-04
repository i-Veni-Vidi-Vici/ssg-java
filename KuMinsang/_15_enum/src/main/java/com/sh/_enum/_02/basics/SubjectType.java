package com.sh._enum._02.basics;

public enum SubjectType {
    JAVA, MYSQL, HTML, CSS, JAVASCRIPT;

    /**
     * <pre>
     *     생성자를 명시적으로 선언할 수 있다.
     *     생성자의 접근 제한자는 private
     *     외부에서 호출 불가
     *     - 런타임에 enum객체가 생성되지 않고, 컴파일 타임에 모두 결정되는것이다
     * </pre>
     * @return
     */
    SubjectType(){}

    public String toLowerCase(){
        return this.name().toLowerCase();
    }
}
