package com.sh._static;

/**
 * <pre>
 * static 필드/메서드
 * - JVM이 사용하는 메모리 영역중 정적영역에서 관리되는 자원
 * - 프로그램실행시에 메모리에 적재되어서, 프로그램 종료시까지 유지됨
 * - 인스턴스간의 데이터 공유 목적으로 사용됨
 * - 무분별한 static 자원 사용은 금물이다.
 * - static자원을 활용하는 대표적 예가 클래스 상수 또는 singleton등이다.
 * </pre>
 */
public class App {
    // static 필드 테스트

    public static void main(String[] args) {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();

        // non-static변수 count를 객체별로 각각 증가
        counter1.increaseCount();
        counter2.increaseCount();
        System.out.println(counter1.getCount());
        System.out.println(counter2.getCount());


        // static 변수 scount(공유)를 각 객체에서 한번씩 증가
        counter1.increaseSCount();
        counter2.increaseSCount();
        System.out.println(counter1.getSCount()); // 2
        System.out.println(counter2.getSCount()); // 2
    }


}
