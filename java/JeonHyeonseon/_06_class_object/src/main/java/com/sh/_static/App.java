package com.sh._static;

/**
 * <pre>
 * static 자원 (static 필드/static 메소드)
 * - JVM이 사용하는 메모리 영역 중 정적영역에서 관리되는 자원
 * - 프로그램실행시에 메모리에 적재되어서, 프로그램 종료시까지 유지된다.
 * - 인스턴스간의 데이터 공유를 목적으로 사용한다.
 * - 무분별한 static 자원사용은 금물이다.
 * - static자원을 활용하는 대표적 예가 클래스 상수 또는 Singletone 등이다.
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // static 필드 테스트
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();

        // non-static변수 count를 객체별로 각각 증가
        counter1.increaseCount();
        counter2.increaseCount();
        System.out.println(counter1.getCount());  // 1
        System.out.println(counter2.getCount());  // 1

        //static변수 scount(공유)를 각 객체에서 한 번씩 증가
        counter1.increaseScount();
        counter2.increaseScount();
        System.out.println(counter1.getScount()); // 2
        System.out.println(counter2.getScount()); // 2

//        abc(); // static이 non-static으로 참조할 수 없다  static -> non-static (x)
        // 객체 생성 후 접근 가능!!
        App app = new App();
        app.abc();
        xyz();  // static -> static (o)
    }

    public void abc(){}
    public static void xyz(){}
}
