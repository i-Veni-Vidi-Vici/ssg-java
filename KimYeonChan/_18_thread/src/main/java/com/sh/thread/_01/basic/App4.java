package com.sh.thread._01.basic;

/**
 * 쓰레드 제어: Thead.sloop(millis:long)
 *  - 해당 쓰레드를 지정한 millis 초 만큼 일시정지 시킨다.
 *  - mills 이후에는 다시 정상 작동한다.
 *  - InterruptedException 에 대한 예외 처리 필수
 */
public class App4 {
    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e); // Checked 예외를 다루기 쉬군 Unchecked 예외로 전환
//            }
//            System.out.println("실행...");
//        }
//        System.out.println(Thread.currentThread().getName());

        // 1. 1초에 한번씩 피자를 출력하는 쓰레드 생성하기
        // extends Thread, implements Runnable
        Pizza pizza = new Pizza();
        pizza.start();

        // 2. 1.5초에 한번씩 계란을 출력하는 쓰레드 생성하기
        Runnable egg = new Egg();
        Thread thread1 = new Thread(egg);
        thread1.start();
        // 방법2
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1_500);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                System.out.println("🍳");
            }
        });
        thread2.start();
    }

    static class Pizza extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1_000);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                System.out.println("🍕");
            }
        }
    }

    static class Egg implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1_500);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                System.out.println("🍳");
            }
        }
    }
}
