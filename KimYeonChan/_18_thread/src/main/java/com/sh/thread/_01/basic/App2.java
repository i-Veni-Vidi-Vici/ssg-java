package com.sh.thread._01.basic;

/**
 * 쓰레드를 생성하는 방법1
 *  - 쓰레드 상속클래스
 * 멀티쓰레드 작업순서는 OS 스케줄링을 따른다.
 *  - 쓰레드 작업순서를 프로그래밍적으로 결정할 수 없다. (우선순위 부여는 가능)
 *  - OS 의 작업명령을 받은 쓰레드 작업을 지속한다. 작업-작업대기를 반복하며 과업을 수행
 */
public class App2 {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread('+');
        MyThread myThread2 = new MyThread('-');
        myThread1.start(); // 새 쓰레드에 새 콜스택을 할당해서 run 메소드 실행
        myThread2.start();

        System.out.println(Thread.currentThread().getName());
    }

    public void print(char ch) {
        for (int i = 0; i < 100; i++) {
            System.out.print(ch);
        }
    }

    static class MyThread extends Thread {
        private char ch;

        public MyThread(char ch) {
            this.ch = ch;
        }

        /**
         * 쓰레드의 작업 내용 run 메소드
         *  - run 메소드를 실행하고, 모든 내용을 실행하면 쓰레드는 종료
         */
        @Override
        public void run() {
            new App2().print(ch);
            System.out.println(Thread.currentThread().getName());
        }
    }
}
