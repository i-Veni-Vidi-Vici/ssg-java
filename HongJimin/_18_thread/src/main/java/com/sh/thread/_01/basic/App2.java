package com.sh.thread._01.basic;

public class App2 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread('+');
        MyThread myThread2 = new MyThread('-');
        myThread.start(); //새 쓰레드에 새 콜스택을 할당해서 run메소드를 실행
        myThread2.start();

        System.out.println(Thread.currentThread().getName()); // main -> 쓰레드 이름 찍는 메소드
    }

    public void print(char ch) {
        for (int i = 0; i < 100; i++) {
            System.out.print(ch);
        }
    }

    static class MyThread extends Thread{ //Thread 클래스 상속
        private char ch;

        public MyThread(char ch) {
            this.ch = ch;
        }

        /**
         * 쓰레드의 작업 내용 run 메소드
         */
        @Override
        public void run() {
            new App2().print(ch);
            System.out.println(Thread.currentThread().getName());
        }
    }
}
