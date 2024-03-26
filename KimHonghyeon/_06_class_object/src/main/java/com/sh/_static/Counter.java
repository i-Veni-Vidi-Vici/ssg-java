package com.sh._static;

public class Counter {
    private static int scount;
    private int count;
    public void increaseCount(){this.count++;}
    public void increaseSCount(){scount++;}

    public static int getScount() {
        return scount;
    }

    public int getCount() {
        return count;
    }
}
