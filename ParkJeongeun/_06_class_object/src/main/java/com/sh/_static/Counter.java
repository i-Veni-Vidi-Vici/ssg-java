package com.sh._static;

public class Counter {
    private static int scount; // static 변수 (클래스 변수) : 클래스마다 생성
    private int count; // non-static 변수 (인트턴스 변수, 멤버 변수) : 객체마다 생성

    public void increaseCount(){
        this.count++;
    }
    public void increaseScount(){
        // scount는 클래스 전역에 공유되는 static 변수 -> 클래스명으로 접근 가능
        // 클래스명(Counter) 생략가능
        Counter.scount++;
    }

    public int getCount(){
        return this.count;
    }
    public int getScount(){
        return Counter.scount;
    }
}
