package com.ssg.thread.alphabet;

public class AlphabetTest {
    public static void main(String[] args) {
        Thread upper = new Thread(() -> {
            for (int i = 65; i <=90 ; i++) {
                System.out.println((char)i);
            }
        });
        Thread lower = new Thread(()->{
            for (int i = 97; i <=122 ; i++) {
                System.out.println((char)i);
            }
        });

        upper.start();
        lower.start();
    }
}
