package com.sh._static;

/**
 * static 자원 (필드/메소드)
 * - JVM 이 사용하는 메모리 영역 중 정적영역에서 관리 되는 자원
 * - 프로그램 실행시에 메모리에 적재되어서, 프로그램 종료시까지 유지된다.
 * - 인스턴스간의 데이터 공유 목적으로 사용한다.
 * - 무분별한 static 자원 사용은 금물이다.
 */
public class App {
    public static void main(String[] args) {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        // non-static 변수 count 를 객체마다 한번씩 증가
        counter1.increaseCount();
        counter2.increaseCount();
        System.out.println(counter1.getCount());
        System.out.println(counter2.getCount());

        // static 변수 scount(공유)
        counter1.increaseScount();
        counter2.increaseScount();
        System.out.println(counter1.getScount());
        System.out.println(counter2.getScount());

        // non-static
        // 객체 생성 후 접근 가능
        App app = new App();
        app.abc();
        // static
        xyz();
    }

    public void abc() { };
    public static void xyz() { };
}
