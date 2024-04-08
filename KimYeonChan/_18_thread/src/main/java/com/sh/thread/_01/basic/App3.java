package com.sh.thread._01.basic;

/**
 * 쓰레드 생성하는 법 2
 *  - Runnable 인터페이스를 구현한 클래스 작성 -> Thread 객채에 전달
 */
public class App3 {
    public static void main(String[] args) {
        Runnable runnable1= new MyRunnable('+');
        Runnable runnable2= new MyRunnable('-');
        Thread th1 = new Thread(runnable1);
        Thread th2 = new Thread(runnable2);
        th1.start();
        th2.start();
        System.out.println(Thread.currentThread().getName());
    }

    public void print(char ch) {
        for (int i = 0; i < 100; i++) {
            System.out.print(ch);
        }
    }

    static class MyRunnable implements Runnable {
        private char ch;

        public MyRunnable(char ch) {
            this.ch = ch;
        }

        @Override
        public void run() {
            new App3().print(ch);
            System.out.print(Thread.currentThread().getName());
        }
    }
}
