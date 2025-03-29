package com.sh.variable;

/**
 * 변수 명명 규칙
 * - 지키지 않을 경우 컴파일 오류 발생
 * - 지키지 않아도 컴파일 오류 발생하진 않지만, 자바 개발자 사이에 혼동을줄 수 있는 부분.
 *
 * A. 컴파일 오류 유발
 *  - 블럭 안에 동일한 변수 이름 작성 x
 *  - 자바 예약어 사용 할 수 없다.
 *  - 변수명은 대소문자 구분
 *  - 숫자로 시작할 수 없다.
 *  - 특수기호는 _,$만 사용 가능하다.
 *
 *  B. 관례적인 규칙
 *   - 변수명 길이에 제한은 없지만, 적절한 길이로 작성해야 한다.
 *   - 합성어로 이루어진 경우 소문자로 시작, 연결되는 단어마다 대문자로 시작 -> viaralbeApp (Camel-Casing)
 *   - 단어 사이에 연결을 _ 로 처리하지 않는다. (Snake- casing X)
 *   - 한글로 변수명을 작성하는 것은 가능하나, 자제한다.
 *   - 전형적인 변수명이 있다면(약속된 변수명이 있다면) 그걸 사용한다.
 *   - 명사형으로 작성한다
 *   - boolean형은 논리형을 유추할 수 있는 변수명을 사용한다.(형용사 처럼)
 *   - 값의 의미를 명확히 대변해야 한다.
 */
public class VariableApp3 {
    public static void main(String[] args) {

        //컴파일 오류 유발
        int age =30;
        // double abe = 20 ;  블럭안에 동일한 변수 이름을 작성할 수 없다.
//        int true = 100; 변수명으로 자바 예약어를 사용 할 수 없다. -> true
        int Age = 30; // 대소문자 구분  Age <-> age 다른 변수명이지만 변수명으론 적절하지 않음.

        //String 1stname = "길동"
        String _1stname = "길동"; // 특수문자 _는 허용가능하다.
        boolean $harp = false; // 특수문자 $는 가능하다.
        //String my_name = "t"; 공백, 특수문자는 사용할 수 없다.
        String myName = "dhgudehd"; //카멜 케이싱 적용하여

        //관례적 명명법(in Java)
        int maxAge = 20;// camel cacing
        int MaxAge = 30; // 클래스명을 제외한 변수, 메소드, 필드명은 모두 소문자로 시작해야되는 암묵적인 관례가 있다.
        // 사용자 이름, 상품코드 , 결혼 여부
        String userName = "dhgudehd";
        int itemCode = 123;
        boolean  isMarried = true;

        //전형적인 변수명 - 누구나 이해하기 쉽다.
        int sum = 100;
        int max = 5;
        int min = 3;

        double goHome = 3.7; // 동사형으로 작성하지말고 명사형으로 작성하고, 메소드 명을 동사형으로 작성

        boolean wannaBe = true; // 논리형은 형용사적으로 작성하고, 긍정형으로 작성한다.
    }
}
