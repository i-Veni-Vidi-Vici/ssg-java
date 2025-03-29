package com.ssg.thread.alphabet;

public class AlphabetTest {
    public static void main(String[] args) {
        Runnable runnable = new Capital();
        Runnable runnable2 = new Small();
        Thread capitalThread = new Thread(runnable);
        Thread smallThread = new Thread(runnable2);
        capitalThread.start();
        smallThread.start();

    }

    static class Capital implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 26; i++) {
                System.out.println("capitalThread : " + (char)('A' + i));
            }
        }
    }

    static class Small implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 26; i++) {
                System.out.println("smallThread : " + (char)('a' + i));
            }
        }
    }
}
