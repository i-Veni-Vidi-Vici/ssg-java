package com.ssg.test1;

import java.util.Random;

public class App1 {
    public void generate(){
        Random rnd = new Random();

        int temp = rnd.nextInt(1, 1000);
        System.out.println((temp >= 300) && (temp <= 600));
    }
}
