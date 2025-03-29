package com.sh._static;

public class Counter {
    private static int scount; //static 변수 ( 클래스 변수 ) - 클래스마다 한번만 생성됨.
    private int count ; //non - static변수(인스턴스 / 멤버 변수) - 객체마다 생성, non - static 변수 -> 객체를 생성할 때 생성됨.

    public void increaseCount(){
        this.count++;
    }

    public void increaseScount(){
        Counter.scount ++;

    }

    public int getCount()
     {
         return this.count;
     }

     public int getScount()
     {
         return this.scount;
     }

}
