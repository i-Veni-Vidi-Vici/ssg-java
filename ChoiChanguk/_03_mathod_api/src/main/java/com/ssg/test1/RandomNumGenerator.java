package com.ssg.test1;

import java.util.Random;

public class RandomNumGenerator {
    public void generate(){
        Random rnd=new Random();
        double randomint;
        randomint=(rnd.nextDouble()*1000)+1;
        System.out.println("난수는 = "+randomint);
        System.out.println((randomint>=300 &&randomint<=600)?"포함된다":"미포함");
    }
}
