package com.sh.variable;


/**
 * 변수 명명 규칙
 * - 지키지 않을 경우 컴파일 오류 유발
 * - 지키지 않아도 컴파일 오류는 나지 않지만, 자바 개발자 사이에 혼동을 줄 수 있느 부분
 *
 * A. 컴파일 오류 유발
 * - 블럭 안에 동일한 변수 이름을 작성할 수 없다.
 * - 변수명은 대소문자를 구분한다.
 * - 숫자로 시작할 수 없다.
 * - 특수 기호는 _$만 사용한다.
 *
 * B.관례적 규칙
 *     - 변수명 길이에 제한은 없지만, 적절한 길이로 작성해야 한다.
 *     - 합성어로 이뤄진 경우, 소문자로 시작, 연결되는 단어마다 대문자로 시작한다. (Camel-Casing)
 *     - 단어 사이의 연결을  _로 처리하지 않는다. (Snake-Casing)
 *     - 한글로 변수명을 작성하는 것은 가능하지만 자제하기!
 *     - 전형적인 변수명이 있다면, 그걸 사용한다.
 *     - 명사형으로 작성한다.
 *     - boolean형은 논리형을 유추할 수 있는 변수명을 사용한다. (형용사)
 *     - 값의 의미를 명확히 대변해야 한다.
 */
public class VariableApp3 {
    public static void main(String[] args) {
        //컴파일 오류 유발
        int age = 20;
//        double age = 20.0; // 블럭 안에 동일한 변수 이름 작성 불가능
//        int true = 100; //자바 예약어 사용할 수 없다.

        int Age = 30; // 대소문자를 구분한다. 변수명은 관례에 따라 소문자로 작성한다.
        boolean True = true;

//        String 1stName = "길동"; // 숫자로 시작할 수 없다.
        String _1stName = "길동"; // 특수문자 _는 허용한다.
        boolean $harp = false; //특수문자 $는 허용한다.
//        String my name = "신사임당"; // 공백 특수문자는 사용할 수 없다.
        String myName = "신사임당"; // 카멜케이싱 적용 케이스를 추천한다.

        // 관례적 명명법
        int maxAge = 20; // 카멜케이싱
        int MaxAge = 30; // 클래스명을 제외한 변수, 메소드, 필드명은 모두 소문자로 시작하는 암묵적인 관례가 잇다.

        //사용자 이름, 상품코드, 결혼 여부
        String userName = "홍지민";
        int productCode = 907;
        boolean isMarried = false;

        //전형적인 변수명 - 누구나 이해하기 쉬운 변수!
        int sum = 1000;
        int max = 10000;
        int min = 10;
        int count = 0;

        double goHome = 3.7; // 변수명은 명사형, 메소드 병은 동사형으로 작성함
        double Home = 3.8;

        boolean wannaBe = true; // 논리형은 형용사 적으로 작성함
        boolean notMarried = false; //긍정형으로 작성한다.







    }
}
