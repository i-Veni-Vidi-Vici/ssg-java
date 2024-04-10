package com.sh.thread._01.basic;

/**
 * <pre>
 * - 쓰레드 제어 - Thread.sleep(millis.long)
 * - mills초 이후에는 다시 정상 작동한다.
 * - interrupedException에 대한 예외처리 필수
 *
 *
 * </pre>
 *
 *
 */


public class App4 {
    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            try { // ctrl + alt + T
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println("💫💫");
//
//        }
//        System.out.println(Thread.currentThread().getName());
        // 1. 1초에 한번 씩 🍕
        // extends Thread, implements Runnable
        Thread thread1 = new Pizza();
        thread1.start();


        // 2. 1.5초에 한번 씩 🍳

        // implements Runnable
//        Thread thread2 = new Thread(new EggThread());
//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 10; i++) {
//                    try {
//                        Thread.sleep(1500);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    System.out.println("🍳");
//                }
//                System.out.println("모든 계란후라이🍳를 출력했습니다.");
//            }
//        });


        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("🍳");
            }
            System.out.println("모든 계란후라이🍳를 출력했습니다.");
        });
        thread2.start();
    }


    static class Pizza extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                System.out.println("🍕");

            }
            System.out.println("모든 피자 출력 했습니다.");

            }
        }

    static class Egg implements Runnable {


        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("🍳");
            }
            System.out.println("모든 계란후라이 출력했습니다.");
        }
    }






    }



