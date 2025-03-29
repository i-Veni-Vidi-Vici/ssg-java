package com.sh._static;

/**
 * <pre>
 *     static 자원 (필드/메소드)
 *     - JVM이 사용하는 메모리 영역중 정적영역에서 관리 되는 자원
 *     - 프로그램 실행시에 메모리에 로드되서, 프로그램 종료시까지 유지됨
 *     - 인스턴스간의 데이터 공유 목적으로 사용한다.
 *     - 무분별한 static자원 사용은 금물이다
 *     - static 자원을 활용하는 대표적 예가 클래스 상수 또는 Singletone 등이다.
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        //static 필드 테스트
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        //non-static변수 count를 객체별로 각각 증가
        counter1.incereaseCount();
        counter2.incereaseCount();
        System.out.println(counter1.getCount());
        System.out.println(counter2.getCount());

        //static 변수인 scount를 각 객체에서 한번씩 증가
        counter1.incereaseSCount(); //scount = 1
        counter2.incereaseSCount(); //scount = 2
        System.out.println(counter1.getScount());
        System.out.println(counter2.getScount());

//        abc(); //static -> non-static (X)
        App app = new App();    //객체를 생성후 접근해야 한다
        app.abc();

        xyz();  //static에서 static을 호출

    }
    public void abc(){}
    public static void xyz(){}
}
