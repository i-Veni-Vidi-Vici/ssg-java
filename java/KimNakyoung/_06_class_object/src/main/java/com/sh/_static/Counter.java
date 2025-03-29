package com.sh._static;

public class Counter {
    private static int scount; // static 변수(클래스 변수) - 클래스마다 생성
    private int count;

    public void increaseCount() { // non-static변수 (인스턴스/멤버 변수) - 객체마다 생성
        this.count++;
    }

    public void increaseSCount() {
        scount++;
    }

    public int getCount(){
        return this.count;
    }

    public int getScount(){
        return this.scount;
    }

}
