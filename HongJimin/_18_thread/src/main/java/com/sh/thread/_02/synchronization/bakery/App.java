package com.sh.thread._02.synchronization.bakery;

/**
 * <pre>
 *     요리사는 빵을 구워서 접시에 제공하면, 손님은 빵을 먹는 예제
 *     - 요리사, 손님 쓰레드
 *     - 접시 공유 자원
 *     - 동기화 처리를 하지 않는다면, 제공하지 않은 빵을 먹거나, 빵을 2개 이상 준비하는 등의 오류를 만나게 됨
 *
 *     쓰레드의 상태 관리 메소드
 *     - wait() WAITING 상태로 변환
 *     - notify(), notifyAll() WAITING 상태의 임의의 쓰레드를 RUNNABLE를 변환
 *
 *     구현해야 할 동기화 기능
 *     - 손님은 접시가 비어있을 때, 요리사가 빵을 만들길(notify) 기다려야 함(waiting)
 *     - 요리사는 접시가 비어있지 않을 때, 손님이 빵을 먹길(notify) 기다려야 함(waiting)
 *     -  waiting 중에 notify를 받으면, 블럭된 다음 부분을 실행하게 됨
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        Plate plate = new Plate();
        Thread consumer = new Thread(new Consumer(plate), "손님");
        Thread baker = new Thread(new Baker(plate), "요리사");
        consumer.start();
        baker.start();
    }
}
