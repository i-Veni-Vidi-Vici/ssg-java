package com.ssg;

import java.util.Random;

public class app5 {
    public static void main(String[] args) {
        Random rand = new Random();
        int a;
        if((a = rand.nextInt(999)+1) < 601 && a > 299) System.out.println(true);
        else System.out.println(false);;
    }
}
