package com.ssg.test1;


import java.util.Random;

public class RandomNumGenerator {
    public void generate(){
    Random rnd = new Random();
        int x=rnd.nextInt(1000)+1;
        System.out.println(x);
        System.out.println((x>=300&&x<=600)?"범위에 포함됩니다.":"범위에 포함되지 않습니다.");


    }
}
