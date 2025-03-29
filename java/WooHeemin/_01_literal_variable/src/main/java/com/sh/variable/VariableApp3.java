package com.sh.variable;

/**
 * 변수 명명 규칙
 * - 지키지 않을 경우 컴파일오류 유발
 * - 지키지 않아도 컴파일 오류는 나지 않지만, 자바 개발자 사이에 혼동
 *
 * A. 컴파일 오류 유발
 * - 블럭안에 동일한 변수이름을 작성할 수 없다.
 * - 자바 예약어 사용할수 없다.
 * - 변수명은 대소문자를 구분하다.
 * - 숫자로 시작할수 없다.
 * - 특수기호는 _ $ 만 사용 가능하다
 *
 * B. 관례적 규칙
 * - 변수명 길이에 제한은 없지만, 적절한 길이로 작성
 * - 합성어로 이루어진 경우, 소문자로 시작, 연결로되는 단어마다 대문자로 시작한다 (Camel-Casing)
 * - 단어 사이의 연결을 _로 처리하지 않는다. (Snake-Casing X)
 * - 한글 사용 X
 * - 전형적이 변수명 사용
 * - 명사형
 * - boolean형은 형용사
 * - 가
 */

public class VariableApp3 {

    public static void main(String[] args) {
        int age = 20;
        // double age = 20.0; // 동일한 변수이름 사용X
        // int true = 100; // 예약어 사용X
        int Age = 30; // 대소문자 구별 O. 관례에 따라 소문자 사용
        boolean True = true; //

        // String 1stName = "길동"; // tntwkfh tlwkrgkftn djqtek
        String _1stName = "길동";
        boolean $harp = false;
        // String my name = "신사임당" // 공백사용불가
        String myName = "신사임당";

        int min, max, sum, average;


    }
}
