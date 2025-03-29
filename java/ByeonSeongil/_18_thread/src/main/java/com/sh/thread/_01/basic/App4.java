package com.sh.thread._01.basic;

import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * 쓰레드 제어 - Thread.sleep(millis:long)
 * - 해당 쓰레드를 지정한 millis 초만큼 일시정지시킨다.
 * - millis 초 이후에는 다시 정상 작동한다.
 * - InterruptedException 에 대한 예외처리 필수
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e); // Checked 예외를 다루기 쉬운 Unchecked 예외로 전환
//            }
//            System.out.println("❤");
//        }
//
//        System.out.println(Thread.currentThread().getName()); // 출력하는과정에서 씹힘
//
        // 1. 1초에 한번씩 🍕를 출력하는 쓰레드 생성하기
        MyThread myThread1 = new MyThread();
        myThread1.start();


        // 2. 1.5초에 한번씩  🍔를 출력하는 쓰레드 생성하기

        Runnable runnable = new MyRunnable();
//        Thread myThread2 = new Thread(runnable);
////        runnable.run();
//        myThread2.start();

//        Thread myThread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 10; i++) {
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    System.out.println("🍔");
//                }
//            }
//        });
////        runnable.run();
//        myThread2.start();

        Thread myThread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("🍔");
            }
        });
    }

    private static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("🍕");
            }
        }
    }
    private static class MyRunnable implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("🍔");
            }
        }
    }
}
