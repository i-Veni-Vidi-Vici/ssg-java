package com.sh.loop_while;

import java.awt.desktop.SystemEventListener;

public class While {
    public void test1(){
        int i = 10;
        while(i>0){
            System.out.println(i);
            i--;
        }
    }
    public void test2(){
        int sum = 0;
        int i = 1;
        while(i<=10){
            sum +=i++;

        }
        System.out.println(sum);
    }   //end of test2

    public void test3(){
        String str = "apple";
        int i = 0;
        while(i<5){
            char ch = str.charAt(i);
            System.out.println(i+" : "+ch);
            i++;
        }
    }   //end of test3

    public void test4(){
        int i = 2;
        int j = 1;
        while(i< 10){
            while(j < 10){
                System.out.printf("%d * %d = %d\n", i, j, i*j);
                j++;
            }
            i++;
            j=1;
        }
    }
}
