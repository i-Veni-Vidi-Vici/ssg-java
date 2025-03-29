package com.sh.variable;

/**
 * 변수 명명 규칙
 *  - 지키지 않을 경우 컴파일 오류 유발
 *  - 지키지 않아도 컴파일 오류는 나지 않지만, 자바개발자 사이에 혼동을 줄 수있는 부분
 *
 *  A. 컴파일 오류 유발
 *  - 블럭안에 동일한 변수이름을 작성할 수 없다.
 *  - 자바 예약어 사용x
 *  - 변수명은 대소문자를 구분한다
 *  - 숫자로 시작할 수 없다.
 *  - 특수기호는 _ $ 만 사용한다.
 *
 *  B.관례적 규칙
 *   - 변수명 길이에 제한은 없지만, 적절한 길이로 작성해야 한다.
 *   - 합성어로 이루어진 경우, 소문자로 시작, 연결되는 단어마다 대문자로 시작 (Camel-Casing)
 *   - 단어 사이의 연결을 _로 처리하지 않는다. (Snake-Casing 인데 X)
 *   - 한글로 변수명을 작성하는 것은 가능하나 자제한다.
 *   - 전형적인 변수명이 있다면, 그걸 사용한다.
 *   - 명사형으로 작성한다.
 *   - boolean형은 논리형을 유추할 수 있는 변수명을 사용한다. (형용사)
 *   - 값의 의미를 명확히 대변해야 한다.
 */


public class VariableApp3 {
    public static void main(String[] args) {
        // 컴파일 오류 유발
//        int age;
//        age = 20;
        int age = 20; // 초기화
//        double age = 20; // 블럭안에 동일한 이름 x
//        int true = 100; // 변수명에 예약어(true) x 예약어 외우는건x
        int Age = 20; // 대소문자 구별한다 하지만 변수명은 소문자로 시작해야한다
        boolean True = true; // 대소문자 구별해서 가능 하지만.. 소문자로 시작 해야한다

//        String 1stName = "길동"; // 변수명 숫자시작x
        String _1stName = "길동"; // 특수문자 _는 허용한다.
        boolean $harp = false; // 특수문자 $는 허용한다.
//        String my_name = "신사임당" // 공백 특수문자는 사용할 수 없다. _ xx
        String myName = "신사임당"; // 카멜케이싱 적용케이스

        // 관례적 명명법
        String amfkamlkfmkamklfkalmfkl = "abc"; // 변수명 길이 제한x 근데. 적당히 하셈
        int maxAge = 20; // 카멜 캐이싱 최대나이
        int MaxAge = 30; // <쓰지마> 클래스 명을 제외한 변수, 메소드, 필드명 모두 소문자로 시작하는 암묵적 클래스 대문자!

        // 사용자 이름, 상품코드, 결혼여부

        // 내가 지은 변수 명
        String name = "kim";
        long goodsCode = 001;
        boolean married = true;

        // 일반적으로 이렇게 씀
        String userName = "하하";
        long productCode = 001;
        boolean ismarried = false;
        String weddingYn = "Y"; // "N"

        String 이름 = "유관순"; //  되긴 하는데.... 한글로 작성하지 말자
        System.out.println(이름);

        // 전형적인 변수명 - 누구나 이해하기 쉽다.

        int sum = 1000;
        int max = 1000000;
        int min = 1;
        int count = 0; // 또는 cnt

        int hap = 1000; // 합.... 하지말자!
        String jumin = "990101-123456"; // 하지말자..!

        double goHome = 3.7; //변수명 명사형 , 메소드명 동사형
        double home = 10; // 변수명 명사형으로 씁시다

        boolean wannaBe = true; // 논리형은 형용사 결혼여부 married
        boolean notMarried = false; // 긍정형으로 작성한다 부정형으로 하면 헷갈린다!!













    }
}
