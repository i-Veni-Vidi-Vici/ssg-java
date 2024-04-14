package com.sh.thread._01.basic;

/**
 * 쓰레드 샘명주기 LifeCycle
 *  - 생성 - 실행 - 종료
 *  - NEW: 쓰레드 객체가 생성되고, 아직 start()를 호출하지 않은 상태
 *  - RUNNABLE: 생행(실행대기) OS 스케쥴링에 의해 실행중인 상태
 *  - 일시정지 상태
 *      - TIMED_WAITING: 지정한 시간동안 일시정지
 *      - WAITING: 다른 쓰레드의 통지(notify, notifyAll)를 기다리는 상태
 *      - BLOCKED: 사용하고자 하는 공유 자원의 락을 기다리는 상태
 *  - TERMINATED: 실행을 마친(run 메스드) 상태
 */
public class App5 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
           // 쓰레드 작업 내용
           for (int i = 0; i < 100_000_000; i++) {
               // 특정 작업
               System.out.print("");
           }
            try {
                Thread.sleep(2_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int i = 0; i < 100_000_000; i++) {
                // 특정 작업
                System.out.print("");
            }
        }, "마이쓰");

        // 메인쓰레드에 반복문을 통해 마이쓰 쓰레드의 상태를 추적한다.
        main:
        while (true) {
            Thread.State state = thread1.getState();
            System.out.println("상태: " + state);
            switch (state) {
                case NEW: thread1.start(); break;
                case TERMINATED: break main;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
