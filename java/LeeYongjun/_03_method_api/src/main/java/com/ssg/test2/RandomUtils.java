package com.ssg.test2;
import java.util.Random;
public class RandomUtils {
    public static void generate() {
        Random rnd=new Random();
        int x=rnd.nextInt();
        System.out.println(x);
        System.out.println(x%2==0?"짝수":"홀수");

    }
}
