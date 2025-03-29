package com.sh.thread._02.synchronization.bakery;

/**
 * <pre>
 * 요리사는 빵을 굽고 접시에 제공하면 , 손님은 빵을 먹는 예제
 * - 요리사, 손님 쓰레드
 * - 공유자원은 접시
 * - 동기화 처리 하지 않는다면,
 *         제공하지 않은 빵을 먹거나 빵을 2개 이상 준비되는 동의 오류를 만나게 된다
 *
 *
 * 쓰레드 상태관리 메소드
 * - wait() WATING상태로 전환
 * - notify(), notityAll() WAITING 상태의 임의의 쓰레드를 RUNNABLE를 변환
 *
 * 구현해야할 동기화 기능
 * - 손님은 접시가 비어있을 떄 요리사가 빵을 만들길 기다려야 한다.(waiting)
 * - 요리사는 접시가 비어있지않을 때 손님이 빵을 먹기를 기다려야 한다
 * - waiting중에 notify를 받으면, 블럭된 다음부분을 실행하게 된다
 * </pre>
 */
public class App1 {
    public static void main(String[] args) {
        Plate plate=new Plate();
        Thread consumer=new Thread(new Consumer(plate),"손님");
        Thread baker = new Thread(new Baker(plate),"요리사");
        consumer.start();
        baker.start();

    }
}
