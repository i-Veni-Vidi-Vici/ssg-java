package com.ssg.test1;

public class RandomNumGenerator {
    public void generate(){
        int rndNum = (int)(Math.random()*1000)+1;
        System.out.println("Is random number between 300~600? : " + (rndNum>=300 && rndNum<=600));
    }
}
