package com.sh._static;


/**
 * static 자원 ( 필드 / 메소드 )
 * - JVM이 사용하는 메모리 영역중 정적영역에서 관리되는 자원
 * - 프로그램 실행시에 메모리에 적재되서, 프로그램 종료시까지 유지된다.
 * - 인스턴스간의 데이터 공유 목적으로 사용한다.
 * - 무분별한 static 자원 사용은 금물이다.
 * - static자원을 대표적으로 활용하는 예가 클래스 상수 또는 singletone 등이다.
 */
public class APP {
    public static void main(String[] args) {
        //static 필드 테스트
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();

        //non - static 변수 count를 객체별로 각각 증가
        counter1.increaseCount();
        counter2.increaseCount();

        System.out.println(counter1.getCount()); // 1
        System.out.println(counter2.getCount()); // 1

        //static 변수 scount(공유)를 각 객체에서 한번씩 증가 시킴
        counter1.increaseScount();
        counter2.increaseScount();

        System.out.println(counter1.getScount()); //2
        System.out.println(counter2.getScount()); //2

        // abc() : 접근 불가능 -> 객체 생성후 접근 가능
        APP app = new APP();
        app.abc();

        xyz();
    }

    public void abc(){
    }

    public static void xyz(){}
}
