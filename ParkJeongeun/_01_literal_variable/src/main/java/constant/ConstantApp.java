package constant;

/**
 * <pre>
 * 상수란
 * - 변하지 않는 값을 보관하는 변수
 * - 변경되어서는 안되는 값을 위해 사용, 수정불가
 * - 파이와 같은 수학적 값은 상수로 관리
 * - 숫자 기본형의 범위도 상수로 관리
 * - 선언 - 값대입 - 사용 절차는 동일하지만, 값대입을 다시 할 수 없음
 * - 관례적으로 상수명은 대무자로 작성, 합성어인 경우 _로 연결
 * </pre>
 */
public class ConstantApp {
    public static void main(String[] args) {
        // 선언 : final로 선언
        final int AGE;
        // 값대입
        AGE = 20;
//        AGE = 21; // 값을 다시 대입할 수 없음
        System.out.println(AGE);
        // 피연산자로 사용할 수 있음
        int yourAge = AGE + 3;

        // 초기화
        final int VALUE = 123;

        // 합성어인 상수
        final double HUMAN_AVG_HEIGHT = 170.33;

        // jdk가 제공하는 상수
        System.out.println(Math.PI);
        System.out.println("byte : " + Byte.MIN_VALUE + " ~ " + Byte.MAX_VALUE);
        System.out.println("short : " + Short.MIN_VALUE + " ~ " + Short.MAX_VALUE);
        System.out.println("int : " + Integer.MIN_VALUE + " ~ " + Integer.MAX_VALUE);
        System.out.println("long : " + Long.MIN_VALUE + " ~ " + Long.MAX_VALUE);

    }
}
