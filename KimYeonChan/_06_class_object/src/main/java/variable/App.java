package variable;

/**
 * 변수의 종류
 * 1. 전역 변수: 클래스 영역에서 선언된 변수
 *      - 클래스 변수 (static 변수)
 *          - 해당 클래스가 처음 사용된 시점 ~ 프로그램 종료
 *      - 인스턴스 변수 (non-static 변수, member 변수)
 *          - 객체 생성 ~ 객체 제거
 * 2. 지역 변수: 메소드 영역에서 선언된 변수
 *      - 매개변수도 지역 변수 이다.
 *      - 메소드 호출 ~ 메소드 리턴
 */
public class App {
    // 전역 변수: 클래스 변수
    private static int snum;
    // 전역 변수: 인스턴스 변수
    private int num;

    public void test(int m) { // 지역 변수
        int k; // 지역 변수
    }
}
