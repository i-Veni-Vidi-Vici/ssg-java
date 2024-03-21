package com.sh._return;

public class App {
    public static void main(String[] args) {
        //리턴 값은 주소를 반환하는가 값을 반환하는가
        int i=0;

        Returner run1 = new Returner();
/*
        run1.printaddr();
        run1.setStr1("5");
        run1.setStr2("10");
        run1.printaddr();
        System.out.println("I :"+System.identityHashCode(run1.getStr1())+" J :"+System.identityHashCode(run1.getStr2()));

        run1.setStr1("일");
        run1.setStr2("이");
        run1.printaddr();
        System.out.println("I :"+System.identityHashCode(run1.getStr1())+" J :"+System.identityHashCode(run1.getStr2()));
*/
        run1.setStr1("5");
        //run1.getStr1()="19";

    }
}
