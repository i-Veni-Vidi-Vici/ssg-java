package VariableApp;

/**변수 명명 규칙
 * 지키지 않을 경우 컴파일 오류 유발
 * 지키지 않아도 컴파일 오류는 나지 않지만, 자바개발자 사이에 혼동을 줄수 있는 부분
 *
 * 블럭안에 동일한 변수이름을 작성할 수 없다.
 * 자바 예약어 사용할 수 없다.
 * 변수명은 대소문자를 구분한다.
 * 숫자로 시작할 수 없다.
 * 특수기호는 _$만 사용가능하다.
 *
 * 관례적 규칙
 * -변수명 길이에 제한은 없지만, 적절한 길이로 작성해야 한다.
 * -합성어로 이루어진 경우, 소문자로 시작 연결되는 단어마다 대문자로 시작(camel-casing)
 * -단어사이의 연결을 _로 하지 않는다.(snake casing)
 * -한글로 변수명을 작성하는 것은 가능하나 자제한다.
 * -전형적인 변수명이 있다면 그걸 사용한다.
 * -명사형으로 작성한다.
 * -boolean형은 논리형을 유추할수 있는 변수명을 사용한다.(형용사)
 * -값의 의미를 명확히 대변해야 한다.
 */



public class VariableApp3 {
    public static void main(String[] args){
    int age = 20;
    int Age = 50;//변수명은 관례에 따라 소문저므올 시작
    boolean True = true;

    String _1stname = "길동"; // 특수문자 _허용한다.
    boolean $harpd = false;
    String myName = "길동"; //카멜캐이싱
    int maxAge=20;  //클래스명을 제외한 변수, 메소드, 필드명은 모든 소문자로 시작하는 암묵적인 관례가 있다//
    String userName = "이순신";
    long productionCode = 1234124121;
    boolean hasLicence = false;
    double goHome = 3.7; //변수명은 명사형으로 작성한다. 메소드명을 동사형으로 작성한다.
    double home = 3.8;

    boolean wannaBe= true ; //논리형은 형용사적으로 작성한다.
    boolean notMarried = false ; //긍정적으로 작성해야한다.


    }
}
