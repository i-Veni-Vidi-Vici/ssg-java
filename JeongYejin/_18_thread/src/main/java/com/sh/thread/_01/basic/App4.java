package com.sh.thread._01.basic;

/**
 * <pre>
 * 쓰레드제어 - Thread.sleep(millis:long)
 * - 해당 쓰레드를 지정한 millis초만큼 일시정지시킨다.
 * - millis초 이후에는 다시 정상 작동한다.
 * - InterruptedException에 대한 예외처리 필수.
 *
 * extends Thread보다 implements Runnable 중 선호되는 것은 Runnable이다.
 * 왜냐하면 상속은 하나만 명시할 수 있기 때문에 다른 클래스를 상속할 자리를 비워두기 위해서이다.
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) { // Exception을 상속받는 Checked 예외
//                throw new RuntimeException(e); // Checked 예외를 다루기 쉬운 Unchecked 예외로 전환
//            }
//            System.out.println("🎈");
//        }
//        System.out.println(Thread.currentThread().getName());

        // 1. 1초에 한번씩 🍕를 출력하는 쓰레드 생성하기
        // extends Thread, implements Runnable
        Thread thread = new MyPizza("🍕");
        thread.start();

        // 2. 1.5초에 한번씩 🍳를 출력하는 쓰레드 생성하기
//        Runnable runnable = new MyFriedEgg("🍳");
//        Thread thread2 = new Thread(runnable);
        Thread thread2 = new Thread(new MyFriedEgg("🍳"));
        thread2.start();

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("🍔");
                }
            }
        });

        thread3.start();

        Thread thread4 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("🍟");
            }
        });

        thread4.start();
    }

    static class MyPizza extends Thread {
        private String s = "🍕";
        public MyPizza(String s) {
            this.s = s;
        }
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e); // 예외처리 안함
                }
                System.out.println(s);
            }
            System.out.println("End of MyPizza");
        }
    }
}
