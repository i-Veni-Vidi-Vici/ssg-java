package com.sh.variable;

/**
 * <h3>변수 명명 규칙</h3>
 * <pre>
 *     - 지키지 않을 경우 컴파일 오류 유발
 *     - 지키지 않아도 컴파일 오류는 나지 않지만, 자바 개발자 사이에 혼동을 줄 수 있음
 *
 *     A. 컴파일 오류 유발
 *     - 블록 안에 동일한 변수 이름을 작성할 수 없다.
 *     - 자바 예약어를 사용할 수 없다.
 *     - 변수명은 대소문자를 구분한다.
 *     - 숫자로 시작할 수 없다.
 *     - 특수 기호는 _,$만 사용 가능하다.
 *
 *     B. 관례적 규칙
 *     - 변수명 길이에 제한은 없지만, 적절한 길이로 작성
 *     - 합성어로 이루어진 경우, 소문자로 시작 연걸 단어마다 대문자로 시작 ( Camel-Casing )
 *     - 단어 사이의 연결을 _로 처리하지 않는다. ( Snake-Casing )
 *     - 한글로 변수명을 작성하는 것은 가능하나 자제한다. ( Encoding Issue )
 *     - 전형적인 변수명이 있다면 사용한다.
 *     - 명사형으로 작성한다.
 *     - boolean 형은 논리형을 유추할 수 있는 변수명을 사용한다.
 *     - 값의 의미를 명확히 대변해야 한다.
 *
 * </pre>
 */
public class VariableApp3 {
    public static void main(String[] args){
        //컴파일 오류 유발
        int age = 20;
//        double age = 20.0; // 블럭 안에 동일한 변수 이름을 작성할 수 없다.
//        int true = 100; // 자바 예약어를 사용할 수 없다.
        int Age = 30; // 대소문자를 구분한다. 변수명은 관례에 따라 소문자로 시작하는게 좋다.
        boolean True = true; // 대소문자를 구분한다. 변수명은 관례에 따라 소문자로 시작하는게 좋다.

//        String 1stName = "홍길동"; // 숫자로 시작할 수 없다.
        String _1stName = "홍길동"; // 특수문자 _는 허용한다.
        boolean $harp = false; // 특수문자 $는 허용한다.
//        String my name = "홍길동"; // 공백은 허용하지 않는다.
        String myName = "홍길동"; // Camel-Casing 적용

        // 관례적 명명법 (자바)
        String abcdefghijklmnopqrstuvwxyz = "Long"; // 적합한 길이로 작성
        int maxAge = 20; // Camel-Casing
        int MaxAge = 30; // 클래스명을 제외한 변수, 메소드, 필드명은 모두 소문자로 시작하는 불문율

        // 사용자 이름, 상품 코드, 결혼 여부
        String userName = "홍길동";
        int codeNum = 123;
        boolean isMarried = true; // boolean(논리형)은 ? 형식으로 질문하는것이 좋기 때문에 형용사적 표현이 좋음

        String 이름 = "홍길동"; // 한글로 변수명을 작성하는 것은 가능하나 자제한다. ( Encoding Issue )

        // 전형적인 변수명 - 누구나 이해하기 쉬움
        int sum = 1000;             // sum == 합
        int max = 10000, min = 0;   // max == 최대, min == 최소
        int count = 0, cnt = 0;     // count, cnt == 숫자 카운트

        double goHome = 3.7, home = 3.8;    // 변수명은 명사형으로, 메소드명은 동사형으로 작성한다.
                                            // home이 명사형이기 때문에 좀 더 적합함
        boolean wannaBe = true;     // 논리형은 형용사적으로 작성한다.
        boolean notMarried = false; // 긍정형으로 작성한다.


    }
}
