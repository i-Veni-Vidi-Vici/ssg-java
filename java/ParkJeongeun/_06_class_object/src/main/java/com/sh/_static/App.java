package com.sh._static;

/**
 * <pre>
 * static 자원 (필드/메소드)
 * - JVM이 사용하는 메모리 영역 중 정적 영역에서 관리되는 자원
 * - 프로그램 실행 시 메모리에 적재되어, 프로그램 종료 시까지 유지
 * - 인스턴스 간 데이터 공유 목적으로 사용함
 * - 무분별한 static 자원 사용은 금물 (메모리 차지함)
 * - static 자원을 활용하는 대표적 예 : 클래스 상수, Singletone 등
 *
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // static 필드 테스트
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();

        // non-static 변수 count를 객체별로 각각 증가
        counter1.increaseCount();
        counter2.increaseCount();
        System.out.println(counter1.getCount()); // 1
        System.out.println(counter2.getCount()); // 1

        // static 변수 scount를 각 객체에서 한번씩 증가(공유되고 있음)
        counter1.increaseScount();
        counter2.increaseScount();
        System.out.println(counter1.getScount()); // 2
        System.out.println(counter2.getScount()); // 2

//        abc(); // static에서 non-static 호출x
        // non-static도 객체 생성 후 접근은 가능!
        App app = new App();
        app.abc();

        xyz(); // static에서 static 호출0
    }

    public void abc(){}
    public static void xyz(){}
}
