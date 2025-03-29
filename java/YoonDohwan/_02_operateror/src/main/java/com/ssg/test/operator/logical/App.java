package com.ssg.test.operator.logical;

public class App {
    public static void main(String[] args){
        int n=55;
        System.out.println(n>1&&n<100);
        char ch1= 'G';
        System.out.println(ch1>=65&&ch1<=90);
        char ch2= 'g';
        System.out.println(ch2>=96&&ch2<=122);
        char yn= 'Y';
        System.out.println(yn==89||yn==121);
        char k = 'z';
        System.out.println((k>=91&&k<=90)||(k>=96&&k<=122) );




    }
}
