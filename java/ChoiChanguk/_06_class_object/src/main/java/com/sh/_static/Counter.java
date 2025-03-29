package com.sh._static;

/**
 *
 */
public class Counter {
    private static int sscount;//static 변수 (클래스 변수)클래스 마다 생성

    public void increaseCount()// non-static변수(인스턴스/멤버) - 객체마다 생성
    {
        this.count++;
    }

    public void increaseScount()
    {
        this.count++;
    }
    private int count;
    public static int getSscount() {
        return sscount;
    }

    public static void setSscount(int sscount) {
        Counter.sscount = sscount;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
