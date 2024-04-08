package com.sh.thread._01.basic;

/**
 * 쓰레드를 생성하는 방법2
 * - Runnable 인터페이스를 구현한 클래스를 작성 후 Thread 객체에 전달 후 실행
 * -
 *
 * calStack -> 공유 x T 쓰레드 마다 생성
 * heap, static -> 공유
 */
public class App3 {
    public static void main(String[] args) {
        Runnable runnable = new MyRunnable('+');
        Runnable runnable2 = new MyRunnable('-');
        Thread th1 = new Thread(runnable);
        Thread th2 = new Thread(runnable2);
        th1.start(); //각 쓰레드별 새 콜스택을 할당 받아서 작업 시작 !
        th2.start();
        System.out.print(Thread.currentThread().getName());
    }
    public void print(char ch){

        for(int i = 0; i<100; i++){
            System.out.print(ch);
        }
    }

    // 매개인자도 없고, 리턴 값도 없는 함수인터페이스로 쓰레드를 만들기 위한 인터페이스 -> Runnable
    static class MyRunnable implements Runnable{
        private char ch;

        /**
         * 쓰레드 작업 내용
         */
        @Override
        public void run() {
            new App3().print(ch);
            System.out.print(Thread.currentThread().getName());
        }

        public MyRunnable(char ch) {
            this.ch = ch;
        }
    }
}
