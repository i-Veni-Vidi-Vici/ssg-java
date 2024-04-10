package com.sh.thread._01.basic;

/**
 *      쓰레드를 생성하는 방법1
 *      - 쓰레드 상속 클래스
 *
 *      - 멀티 쓰레드 작업순서는 OS 스케줄링을 따름
 *          - 쓰레드의 작업순서를 프로그램적으로 결정할 수 없음(우선순위는 부여 가능)
 *          - OS의 작업 명령을 받은 쓰레드 작업을 지속한다. 작업 - 작업대기를 반복하면 과업을 수행!
 *          - run 메소드의 모든 코드를 실행하면  쓰레드가 종료.
 *          - 모든 쓰레드가 종료되면, 프로세스가 종료됨
 */
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
