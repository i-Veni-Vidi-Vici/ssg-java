package com.sh.thread._01.basic;

/**
 * <pre>
 * 쓰레드 제어 - Thread.sleep(millis:long)
 * - 해당 쓰레드를 지정한 millis초만큼 일시정지시킨다.
 * - millis초 이후에는 다시 정상 작동한다.
 * - InterruptedException(방해받았어요. Exception라는 의미)에 대한 예외처리 필수이다.
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            try{
                Thread.sleep(1000); // 1초(1000)마다 일시정지시킨다
            } catch (InterruptedException e) {  // InterruptedException은 checked예외이다.
                throw new RuntimeException(e); // Checked예외를 다루기 쉬운 Unchecked예외로 전환
            }
            System.out.println("🎃");
        }
        System.out.println(Thread.currentThread().getName()); // main쓰레드 작동했다는 의미

        // 1. 1초에 한 번씩 🍕를 10번 출력하는 쓰레드 생성하
        // extends Thread
        Thread thread1 = new Thread();
        thread1.start();

        // 2. 1.5초에 한 번씩 🍳를 10번 출력하는 쓰레드 생성하기
        // implements Runnable
//        Thread thread2 = new Thread(new EggThread()); // 방법 1
//        Thread thread2 = new Thread(new Runnable() { // 방법 2
//            @Override
//            public void run() {
//                for (int i = 0; i < 10; i++ ) {
//                    try {
//                        Thread.sleep(1500);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    System.out.println("🍳");
//                }
//                System.out.println("모든 🍳계란후라이🍳를 출력했습니다");
//            }
//        });
        // Runnable 람다로 바꿔서 사용할 수 있다.
        Thread thread2 = new Thread(() -> { // 방법 3
            for (int i = 0; i < 10; i++ ) {
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("🍳");
                }
                System.out.println("모든 🍳계란후라이🍳를 출력했습니다");
        });
        thread2.start();
    }

    // extends Thread
    static class PizzaThread extends Thread{
        @Override
        public void run() {
            for(int i =0 ; i < 10; i++) {
                try {
                    Thread.sleep(1000); // 1초(1000)마다 일시정지시킨다
                } catch (InterruptedException e) {  // InterruptedException은 checked예외이다.
                    throw new RuntimeException(e); // Checked예외를 다루기 쉬운 Unchecked예외로 전환
                }
                System.out.println("🍕");
            }
            System.out.println("모든 🍕피자🍕를 출력했습니다.");
        }
    }

    // Implements Runnable
    static class EggThread implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++ ) {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("🍳");
            }
            System.out.println("모든 🍳계란후라이🍳를 출력했습니다");
        }
    }
}
