package com.sh.thread._01.basic;


/**
 *
 * <pre>
 *  쓰레드 생명주기 LifeCycle
 *  - 생성 - 실행 - 종료순으로 쓰레드 처리된다.
 *  - NEW 쓰레드객체가 생성되고, 아직 start()를 호출 하지 않은 상태
 *  - RUNNABLE 실행 (실행대기) OS스케쥴링에 의해 실행중인 상태
 *  - 일시정지 상태
 *          - WAITING 다른 쓰레드의 통지(notify, notifyAll)를 기다리는 상태
 *          - TIMED_WAITING 지정한 시간동안 일시정지( 끝나면 다시 runnable로 돌아옴)
 *          - BLOCKED 사용하고자 하는 공유자원의 락을 기다리는 상태
 *  - TERMINATED 실행을 마친(run메소드) 상태
 *
 *
 * </pre>
 *
 *
 */


public class App5 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            // 쓰레드의 작업내용
            for (int i = 0; i < 1_000_000_000; i++) {
                //특정작업
                System.out.print(""); // 출력문 넣으면 느려짐
            }
            // ~작업과 작업사이에 2초간 재우는 쓰레드 들어옴~
            try {
                Thread.sleep(2000); // 2 초씩 재운다.
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int i = 0; i < 1_000_000_000; i++) {
                //특정작업
            }
        },"마이쓰");

        // 메인쓰레드에서 반복문을 통해 마이쓰 쓰레드의 상태를 추적한다.
        while (true) {
            Thread.State state = thread.getState();
            System.out.println("상태 : " + state);

            if(state == Thread.State.NEW){
                thread.start(); // NEW는 만들어지고 start 전
            }

            if(state == Thread.State.TERMINATED){
                break; // TERMINATED는 종료된거니까
                 }

            try {
                thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }



    }
}
