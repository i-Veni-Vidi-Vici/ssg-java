package com.sh._static;

public class App {
    /**
     * static 자원(필드/메모리)
     *  -JVM이 사용하는 메모리 영역 중 정적영역에서 관리되는 자원
     *  -프로그램실행시에 메모리에 적재되어 프로그램 종료시까지 유지
     *  -인스턴스간의 데이터 자원 공유 목적
     *

     */

    public static void main(String[] args) {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        counter1.increaseCount();
        counter2.increaseCount();
        System.out.println("counter1: "+counter1.getCount());
        System.out.println("counter2: "+counter2.getCount());
        counter1.increaseSCount();
        System.out.println("sCount: "+counter1.getScount());
        counter2.increaseSCount();
        System.out.println("sCount: "+counter2.getScount());
    }
}
