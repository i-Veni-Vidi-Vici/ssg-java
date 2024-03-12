package variable;

public class VariableApp2 {
    /**
     * 변수 사용방법
     * 1. 자료형을 지정해서 선언
     * 2. 변수에 값을 대입
     * 3. 변수 사용 (출력문, 피연산자 등)
     *
     * 기본 자료형 (8가지)
     * - 다양한 리터럴(값)을 형태에 따라 지정한 크기의 공간으로 처리할지 컴파일러와 약속한 단위
     * 1. 정수
     * - byte : 1byte
     * - short : 2byte
     * - int : 4byte (기본형)
     * - long : 8byte
     *
     * 2. 실수
     * - float : 4byte (유효자리수 7자리까지 보장)
     * - double : 8byte (기본형 / 유효자리수 16자리까지 보장)
     *
     * 3. 문자
     * - char : 2byte
     *
     * 4. 논리
     * - boolean : 1byte
     *
     * 문자열은 참조자료형 String 타입으로 처리 (기본형 아님)
     *
     * @param args
     */
    public static void main(String[] args) {
        // 1. 선언
        byte bnum;
        short snum;

        // 실수 사용시 double을 기본적으로 사용
        float fnum;

        // 문자
        char ch;

        // 논리
        boolean bool;

        // 문자열
        String str;

        // 2. 값대입
        bnum = 123;
        snum = 10_000;

        fnum = 123.456f; // 모든 실수 리터럴의 기본타입은 double이므로 float임을 명시해야함

        ch = 'ㅋ';
        ch = 97; // 정수 대입하면 ascii code에 따라 문자로 변환 후 처리

        bool = true;
        bool = !bool; // 반전연산자

        str = "안녕하세요";

        // 3. 사용
        System.out.println("bnum = " + bnum);
        System.out.println("snum = " + snum);
        System.out.println("fnum = " + fnum);
        System.out.println("ch = " + ch);
        System.out.println("bool = " + bool);
        System.out.println("str = " + str);

        // 초기화 : 변수의 선언과 값대입을 동시에 하는 것
        int i = 100;
        System.out.println(i);

        // 선언 - 값대입 - 사용의 순서를 반드시 지켜야 함


    }
}
