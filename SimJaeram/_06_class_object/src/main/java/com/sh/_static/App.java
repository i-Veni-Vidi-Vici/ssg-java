package com.sh._static;

/**
 * <pre>
 *     static 자원 (필드/메소드)
 *     - JVM이 사용하는 메모리 영역 중 정적 영역에서 관리되는 자원
 *     - 프로그램 실행 시에 메모리에 적재되어서, 프로그램 종료시까지 유지된다.
 *     - 인스턴스 간의 데이터 공유 목적으로 사용한다.
 *     - 무분별한 static 자원 사용은 금물이다.
 *     - static 자원을 활용하는 대표적 예가 클래스 상수 또는 Singletone 등이다.
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // static 필드 테스트
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();

        //
        counter1.increaseCount();
        counter2.increaseCount();
        System.out.println(counter1.getCount());
        System.out.println(counter2.getCount());

        // static 변수 scount (공유)를
        counter1.increaseSCount();
        counter2.increaseSCount();
        System.out.println(counter1.getScount());
        System.out.println(counter2.getScount());

//        abc();    // static -> non-static     (x)
        // 객체 생성 후 접근은 가능
        App app = new App();
        app.abc();

        App.xyz();  // static -> static         (o)
    }

    public void abc() {}
    public static void xyz() {}
}
