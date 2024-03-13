package variable;

/**
 * <pre>
 * 변수 명명 규칙
 * - 지키지 않을 경우 컴파일 오류
 * - 지키지 않아도 컴파일 오류는 나지 않지만, 자바개발자 사이에 혼동을 줄 수 있는 부분
 *
 * 1. 컴파일 오류 유발
 * - 블럭 안에 동일한 변수 이름 작성할 수 없음
 * - 자바 예약어 사용할 수 없음
 * - 변수명은 대소문자 구분
 * - 숫자로 시작 X
 * - 특수기호는 _ $만 사용 가능
 *
 * 2. 관례적 규칙
 * - 변수명 길이에 제한은 없지만 적절한 길이로 작성
 * - 합성어로 이루어진 경우, 소문자로 시작하고 연결되는 단어마다 대문자로 시작 (Camel-Casing)
 * - 단어 사이의 연결을 _로 처리 X (Snake-Casing X)
 * - 한글로 변수명을 작성하는 것은 가능하나, 자제
 * - 전형적인 변수명이 있다면 그것을 사용
 * - 명사형으로 작성
 * - boolean형은 논리형을 유추할 수 있는 변수명 사용 (형용사)
 * - 값의 의미를 명확히 대변
 * </pre>
 */
public class VariableApp3 {
    public static void main(String [] args) {
        // 컴파일 오류 유발
        int age = 20;
//        double age =20; // 블럭 안에 동일한 변수 X
//        int true = 100; // 자바 예약어 사용 X
        int Age = 30; // 대소문자 구분해서 가능은 하나, 변수명은 관례에 따라 소문자로 시작
        boolean True = true; // 대소문자 구분해서 가능은 하나, 변수명은 관례에 따라 소문자로 시작

//        String 1stName = "길동"; // 변수명은 숫자로 시작 X
        String _1stName = "길동"; // 특수문자 _는 허용
        boolean $harp = false; // 특수문자 $는 허용
        String my_name = "신사임당"; // 공백 특수문자는 사용 X
        String myName = "신사임당"; // 카멜케이싱 적용 추천

        // 관례적 명명법 (자바)
        String akljlgjliegjalkdlglaksjgi = "abc"; // 변수명 길이에 제한은 없지만 적절한 길이로 작성
        int maxAge = 20; // 카멜케이싱
        int MaxAge = 30; // 클래스명을 제외한 변수, 메소드, 필드명은 모두 소문자로 시작하는 암묵적 관례있음
        // 사용자 이름, 상품코드, 결혼여부
        String userName = "나";
        String productCode = "BCV-123";
        boolean isMarried = true;
        boolean hasLicence = false;

        String 이름 = "나나"; // 한글 변수명 가능하나 자제

        // 전형적인 변수명 : 누구나 이해하기 쉬움
        int sum = 1000;
        int max = 100000;
        int min = 1;
        int count = 0; // cnt라고도 씀

        double goHome = 3.7; // 가능은 하나 변수명은 명사형, 메소드명은 동사형
        double home = 3.7;

        boolean wannaBe = true; // 논리형은 형용사형으로 작성
        boolean notMarried = false; // 긍정형으로 작성

    }
}
