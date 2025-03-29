package com.sh.thread._01.basic;

/**
 * <pre>
 * 쓰레드를 생성하는 방법2
 * - Runnable인터페이스를 구현한 클래스를 작성 -> Thread객체에 전달
 *
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        Runnable runnable1 = new MyRunnable('+');
        Runnable runnable2 = new MyRunnable('-');
        Thread th1 = new Thread(runnable1);
        Thread th2 = new Thread(runnable2);
        th1.setName("일꾼1");
        th2.setName("일꾼2");
        th1.start(); // 각쓰레드별 새 콜스택을 할당 받아서 작업시작!
        th2.start();
        System.out.print(Thread.currentThread().getName()); // main
    }

    public void print(char ch) {
        for (int i=0; i<100; i++) {
            System.out.print(ch);
        }
    }

    static class MyRunnable implements Runnable {
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
