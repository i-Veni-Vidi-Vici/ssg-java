package com.ssg.thread.alphabet;

public class AlphabetTest {
    public static void main(String[] args) {
        Thread alphaUpperThread = new Thread(() -> {
            for(char i='A'; i<='Z'; i++)
                System.out.println("Upper : " + i);
        });

        Thread alphaLowerThread = new Thread(() -> {
            for(char i='a'; i<='z'; i++)
                System.out.println("\tLower : " + i);
        });

        alphaUpperThread.start();
        alphaLowerThread.start();
    }
}
