package com.sh.thread._01.basic;

/**
 * <pre>
 *
 * 쓰레드를 생성하는 방법 1
 * - 쓰레드 상속클래스 생성
 *
 * 멀티쓰레드 작업순서는 OS 스케줄링을 따른다.
 * - 쓰레드 작업 순서를 프로그램적으로 결정할 수 없다. -> 우리가 순서를 정할 수 없다는 뜻. ( 우선순위 부여는 가능하지만 , 잘 먹히진 않는다.)
 * - OS의 작업 명령을 받은 쓰레드가 작업을 지속한다. 작업 - 작업대기를 반복하며 과업을 수행하게 된다!
 * - run 메소드의 모든 코드를 실행하면 쓰레드가 종료
 * - 모든 쓰레드가 종료되면 프로세스가 종료된다.
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        //현재 스레드
        MyThread myThread = new MyThread('+');
        MyThread myThread2 = new MyThread('-');
        myThread2.start();
        myThread.start();

        System.out.println(Thread.currentThread().getName());

    }
    public void print(char ch){

        for(int i = 0; i<100; i++){
            System.out.print(ch);
        }
    }

    static class MyThread extends Thread{

        private char ch;

        public MyThread(char ch) {
            this.ch = ch;
        }

        /**
         * 쓰레드의 작업 내용 run메소드
         * - run메소드를 실행하고, 모든 내용을 실행하면 쓰레드 종료 !
         */
        @Override
        public void run() {
            new App2().print(ch);
            System.out.println(Thread.currentThread().getName());

        }
    }
}
