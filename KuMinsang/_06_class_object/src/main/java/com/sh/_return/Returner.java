package com.sh._return;

public class Returner {
    private String str1 = "1";
    private String str2 = "2";

    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }

    public String getStr2() {
        return str2;
    }

    public void setStr2(String str2) {
        this.str2 = str2;
    }

    public void printaddr(){
        System.out.println("i :"+System.identityHashCode(str1));
        System.out.println("i :"+System.identityHashCode(str2));


    }
}
