package com.ssg.test2;

public class RandomUtils {
    public static void generate(){
        int rndNum = (int)(Math.random()*1000)+1;
        System.out.println("Is random number between 300~600? : " + (rndNum>=300 && rndNum<=600));
    }
}
