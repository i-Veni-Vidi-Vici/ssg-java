package com.sh.thread._01.basic;

/**
 * <pre>
 * 쓰레드제어 - Thread.sleep(millis.long)
 * - 해당 쓰레드를 지정한 millis초만큼 일시정지시킨다.
 * - milis초 이후에는 다시 정상 작동한다.
 * - InterruptedException에 대한 예외처리 필수.
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {

//        for(int i = 0; i < 10; i++){
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e); // Checked예외를 다루기 쉬운 Unchecked예외로 전환
//            }
//            System.out.println("🚗");
//        }
//        System.out.println(Thread.currentThread().getName());

        // 1. 1초에 한번씩 ⛽를 출력하는 쓰레드 생성하기
        // extends Thread, Implements Runnable
        Pizza pizza = new Pizza();
        pizza.start();

        // 2. 1.5초에 한번씩 🚙를 출력하는 쓰레드 생성하기
        Runnable egg = new Egg();
        Thread thread1 = new Thread(egg);
        thread1.start();
    }

    static class Pizza extends Thread {
        @Override
        public void run() {
            for(int i = 0; i < 10; i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("🚗");
            }
            System.out.println("모든 피자를 출력했습니다.");
        }
    }

    static class Egg implements Runnable {
        @Override
        public void run() {
            for(int i = 0; i < 10; i++){
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("🚓");
            }
        }
    }


}
