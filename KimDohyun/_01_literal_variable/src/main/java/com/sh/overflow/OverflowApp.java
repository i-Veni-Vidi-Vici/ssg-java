package com.sh.overflow;

public class OverflowApp {
    public static void main(String [] args){
        int i = Integer.MAX_VALUE;
        i = i;
        System.out.println(i);
    }
}
