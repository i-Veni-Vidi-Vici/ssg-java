package com.sh.thread._01.basic;
/**
 * <pre>
 *     ### 쓰레드를 생성하는 방법2
 *      - Runnable 인터페이스를 구현한 클래스를 작성 → Thrad를 작성
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        Runnable runnable1 = new MyRunnable('+');
        Runnable runnable2 = new MyRunnable('-');
        Thread th1 = new Thread(runnable1); //Thread 객체에 runnable 전달
        Thread th2 = new Thread(runnable2); //Thread 객체에 runnable 전달
        th1.start(); //각 쓰레드별 새 콜스택을 할당받아서 작업을 시작함!
        th2.start();
        System.out.print(Thread.currentThread().getName()); //현재 쓰레드 이름
    }

    public void print(char ch) {
        for (int i = 0; i < 100; i++) {
            System.out.print(ch);
        }
    }

    static class MyRunnable implements Runnable{
        private char ch;

        public MyRunnable(char ch) {
            this.ch = ch;
        }

        /**
         * 쓰레드 작업 내용
         */
        @Override
        public void run() {
            new App3().print(ch);
            System.out.print(Thread.currentThread().getName());
        }
    }
}
