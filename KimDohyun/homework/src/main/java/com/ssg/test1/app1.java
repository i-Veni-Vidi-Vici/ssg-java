package com.ssg.test1;
import java.util.*;
public class app1 {
    public static void main(String[] args) {
        Random random = new Random();
        int ran = random.nextInt(1000)+1;
        if( ran > 299 && ran < 600){
            System.out.println("포함");
        }
        else System.out.println("미포함");

    }


}
