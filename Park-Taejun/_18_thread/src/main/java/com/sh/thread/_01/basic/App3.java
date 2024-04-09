package com.sh.thread._01.basic;

import java.util.TreeMap;

/**
 * <pre>
 *쓰레드를 생성하는 방법2
 *-Runanable 인터페이스를 구현한 클래스를 작성. -> Thread 객체에 전달
 *
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        Runnable runnable1 = new MyRunnable('+'); // 이 자체는 쓰레드가 아니고 실제로 thread 객체 만들어야함
        Runnable runnable2 = new MyRunnable('-');
        Thread th1 = new Thread(runnable1); // 쓰레드 객체 만들고 전달해줘야함
        Thread th2 = new Thread(runnable2); // 쓰레드 객체 만들고 전달해줘야함
        th1.start(); // 각 쓰레드별 새 콜스택을 할당 받아서 작업을 시작함! 내 러너블 객체 만들고 쓰레드로 감싸줌
        th2.start();
        System.out.print(Thread.currentThread().getName());
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
        /**
         * 쓰레드 작업 내용
         */
        public void run(){
            new App3().print(ch);
            System.out.print(Thread.currentThread().getName());
        }

    }
}
