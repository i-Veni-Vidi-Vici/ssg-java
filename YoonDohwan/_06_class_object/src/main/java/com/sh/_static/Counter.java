package com.sh._static;

public class Counter {
    private static int scount;
    private int count;
    public void increaseCount(){
        this.count++;
    }
    public void increaseSCount(){
        Counter.scount++; //스태틱 표현법
    }
    public int getCount(){
        return this.count;
    }
    public int getScount(){
        return scount;
    }
}
