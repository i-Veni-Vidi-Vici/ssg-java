package com.sh.variable;

public class VariableApp3 {

    /**
     * 변수 명명 규칙
     * - 지키지 않을 경우 컴파일 오류 유발
     * - 지키지 않아도 컴파일 오류는 나지 않지만, 자바 개발자 사이에 혼동을 줄 수 있다.
     *
     * A. 컴파일 오류 유발
     *  - 블럭안에 동일한 변수이름을 작성할 수 없다.
     *  - 자바 예약어 사용할 수 없다.
     *  - 변수명은 대소문자 구분한다.
     *  - 숫자로 시작 할 수 없다.
     *  - 특수기호는 _, $만 사용 가능
     *
     *  B. 관례적인 규칙
     *   - 변수명 길이에 제한은 없지만, 적절한 길이로 작성해야 한다.
     *   - 합성어로 이루어진 경우, 소문자로 시작, 연결되는 단어마다 대문잘 시작(camel-casing
     *   - 단어 사이에 연결을 _로 하지 않는다 (snake-Casing)
     *   - 한글로 변수명을 작성 하는 것은 가능하다 자제한다.
     *   - 전형적인 변수명이 있다면, 그걸 사용한다.
     *   - 명사형으로 작성
     *   - boolean형은 논리형을 유추할 수 있는 변수명을 사용한다.(형용사)
     *   - 값의 의미를 명확히 대변해야 한다.
     * @param args
     */

    public static void main(String[] args)
    {
        int age=20;
        //int double, true 변수이름 동일, 예약어
        int Age=20; // 사용은 가능하나 관례는 소문자로 시작
        //String 1stName = 숫자 시작 안됨
        String _1stName = "최창욱";// _시작해서 가능
        boolean $harp = false;// 유일하게 _,$ 시작은 가능
        String myName = "신사임당";// 카멜케이싱 적용케이스 추천한다
        String userName = "사용자 이름";
        String goodsCode = "상품코드";
        boolean married = false;

        String 이름 = "유관순"; // 가능은 하지만 오류가 날 수 있다.

        int sum;
        int max;
        int min;
        int cnt;
        int hap; // 추천 하지는 않음 나중에 가면 막상 안읽힘
        String jumin; // 이것또한 추천 안함

        double goHome = 3.7; //변수명은 명사, 클래스 = 형용사
        double home;





    }
}
