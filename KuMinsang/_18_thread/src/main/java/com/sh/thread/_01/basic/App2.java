package com.sh.thread._01.basic;

public class App2 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread('+');
        MyThread myThread2 = new MyThread('-');
        myThread.start();   //새 쓰레드에 새 콜스택을 할당해서 run 메소드를 실행
        myThread2.start();

    }
    public void print(char ch){
        for(int i = 0; i < 100; i++){
            System.out.print(ch);
        }
    }


    static class MyThread extends Thread{
        private char ch;

        public MyThread(char ch){
            this.ch = ch;
        }

        /**
         * 쓰레드의 작업내용을 실행하는것이 run 메소드
         * - run 메소드를 실행하고, 모든 내용을 실행하면 쓰레드 종료
         */
        @Override
        public void run() {
            App2 app2 = new App2();
            app2.print(ch);
            super.run();
        }
    }
}
