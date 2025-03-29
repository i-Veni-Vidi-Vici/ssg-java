package com.sh.typecasting;

import static java.lang.Long.MAX_VALUE;

public class TypeCastingApp {

    public static void main(String[] args){
        short snum = 10000;
        byte bnum = (byte) snum;
        short fnum = (short) MAX_VALUE;
        float dnum = fnum;
        System.out.println(dnum);
    }
}
