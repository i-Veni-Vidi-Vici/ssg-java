package com.sh._static;

public class Counter {
    private static int scount; // static 변수 (클래스 변수): 클래스마다 생성
    private int count; // non-static 변수 (인스턴스/멤버 변수): 객체마다 생성

    public void increaseCount() {
        this.count++;
    }

    public void increaseScount() {
        scount++;
    }

    public int getCount() {
        return count;
    }

    public int getScount() {
        return scount;
    }
}
