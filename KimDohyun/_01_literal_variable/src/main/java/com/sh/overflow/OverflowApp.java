package com.sh;

public class OverflowApp {
    public static void main(String [] args){
        int i = Integer.MAX.VALUE;
        i = i+1;
        System.out.println(i);
    }
}
