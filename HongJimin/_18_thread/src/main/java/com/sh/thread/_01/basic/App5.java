package com.sh.thread._01.basic;

/**
 * <pre>
 *  ### 쓰레드 생명 주기 LifeCycle
 * - 생성 → 실행 → 종료 순으로 쓰레드 처리됨
 * - NEW : 쓰레드 객체가 생성되고, 아직 start( )를 호출하지 않은 상태
 * - RUNNABLE : 실행(실행 대기) → OS 스케줄링에 의해 실행중인 상태
 * - 일시 정지 상태
 *     - TIMED_WAITING : 지정한 시간 동안 일시 정지
 *     - WAITING : 다른 쓰레드의 통지(notify, notifyAll)를 기다리는 상태
 *     - BLOCKED : 사용하고자 하는 공유 자원의 락을 기다리는 상태
 * - TERMINATED : 실행을 마친 ( run 메소드) 상태
 * </pre>
 */
public class App5 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
           //쓰레드의 작업 내용
            for (int i = 0; i < 2_000_000_000; i++) {
                //특정 작업
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int i = 0; i < 2_000_000_000; i++) {
                //특정 작업
            }
        }, "마이쓰");

        //메인 쓰레드에 반복문을 통해 마이쓰 쓰레드의 상태를 추적함
        while (true) {
            Thread.State state = thread.getState();
            System.out.println("상태 : " + state);
            if (state == Thread.State.NEW)
                thread.start();

            if(state == Thread.State.TERMINATED)
                break;

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
