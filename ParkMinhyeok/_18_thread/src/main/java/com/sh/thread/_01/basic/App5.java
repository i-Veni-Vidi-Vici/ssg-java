package com.sh.thread._01.basic;

public class App5 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            {
                for (int i = 0; i < 1_000_000_000; i++) {
                    // 특정작업
                    System.out.print("");
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                for (int i = 0; i < 1_000_000_000; i++) {
                    // 특정작업
                    System.out.print("");
                }
            }
        }, "마이쓰");
        // 메인쓰레드 반복문을 통해 마이쓰 쓰레드의 상태를 추적한다.
        while (true) {
            Thread.State state = thread.getState();
            System.out.println("상태 : " + state);
            if (state == Thread.State.NEW)
                thread.start();
            if (state == Thread.State.TERMINATED)
                break;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
