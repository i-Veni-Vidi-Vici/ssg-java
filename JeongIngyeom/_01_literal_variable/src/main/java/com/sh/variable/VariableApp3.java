package com.sh.variable;

public class VariableApp3 {

    /**
     * 변수 명명 규칙
     * - 지키지 않을 경우 컴파일 오류 유발
     * 1. 블럭 안에 동일한 변수 이름을 작성할 수 없다.
     * 2. 자바 예약어 사용할 수 없다.
     * 3. 변수명은 대소문자를 구분한다.
     * 4. 숫자로 시작할 수 없다.
     * 5. 특수기호는 _ $만 사용 가능하다.
     *
     * - 컴파일 오류는 나지 않지만, 관례적인 규칙
     * 1. 변수명 길이에 제한은 없지만, 적절한 길이로 작성해야 한다.
     * 2. 합성어로 이루어진 경우, 소문자로 시작, 연결되는 단어마다 대문자로 시작한다.(=Camel-Casing 사용)
     * 3. 단어 사이에 연결을 _로 처리하지 않는다. (=Snake-Casing 사용 X)
     * 4. 한글 변수명이 가능은 하지만, 자제한다.
     * 5. 전형적인 변수명이 있다면, 그걸 사용한다.
     * 6. 명사형으로 작성한다.
     * 7. boolean형은 논리형을 유추할 수 있는 변수명을 사용한다. (형용사 느낌)
     * 8. 값의 의미를 명확히 대변해야 한다.
     *
     * @param args
     */
    public static void main(String[] args) {
        // 컴파일 오류 유발
        int age = 20;
        //double age = 20.0;        // 한 블럭 안에 동일한 변수명을 사용할 수 없다.
        //int true = 100;           // 자바 예약어를 사용할 수 없다.
        int Age = 30;               // 대소문자를 구분한다. but, 변수명은 관례에 따라 소문자로 시작하자!
        //String 1stName = "길동";   // 숫자로 시작할 수 없다.
        String _1stName = "길동";    // 특수문자 _는 허용한다.
        boolean $harp = false;      // 특수문자 $는 허용한다.
        //String my name = "홍길동"   // 공백은 사용할 수 없다.
        String myName = "홀길동";     // 카멜케이싱 적용!!

        // 관례적 명명법
        int maxAge = 100;           // 카멜케이싱
        int MaxAge = 100;           // 클래스명을 제외한 변수, 메소드, 필드명은 모두 소문자로 시작하는 암묵적 관례가 있다.

        // 사용자 이름, 상품 코드, 결혼 여부
        String userName = "홍길동";
        String productCode = "AAA";
        boolean isMarried = false;

        String 이름 = "홀길동";        // 한글 변수명은 자제한다.

        int max = 100000;
        int min = 1;
        int count = 0;
        int cnt = 0;

        int hap = 1000;
        String jumin = "990909-1234567";

        double goHome = 3.7;        // 변수명은 명사형으로 작성한다. 메소드명을 동사형으로 작성한다.
        double home = 3.8;

        boolean wannaBe = true;     // 논리형은 형용사적으로 작성한다.
        boolean notMarried = false; // 부정형으로 작성하지 않는다.

    }
}
