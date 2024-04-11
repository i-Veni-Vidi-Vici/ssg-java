package com.sh.thread._02.synchronization.bakery;

public class Plate {
    private int breadNo; // 생성한 빵번호
    private boolean empty = true; // 접시가 비었는지 여부

    /**
     * 손님 쓰레드용 메소드
     */
    public synchronized void eatBread(){
        // 접시가 비어있다면, 요리사가 빵을 만들길 기다려야 한다.
        if(this.empty) {
            try {
                wait(); // 블럭 BLOCKED (다음 줄이 실행되지 않고 기다린다)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("[손님] " + breadNo + "번 빵을 먹었습니다.");
        this.empty = true;
        notify(); // waiting중인 요리사쓰레드에게 알림처리.
    }

    /**
     * 요리사 쓰레드용 메소드
     */
    public synchronized void makeBread(int breadNo){
        // 접시가 비어있지 않은 경우, 손님이 빵을 먹기를 기다려야 한다.
        while(!this.empty) { // 무한반복 , while/if 모두 가능하다.
            try {
                wait(); // 블럭 BLOCKED
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("[요리사] " + breadNo + "번 빵을 만들었습니다.");
        this.breadNo = breadNo;
        this.empty = false;
        notify(); // 빵을 기다리는 손님쓰레드를 위해서 notify를 해야한다. -> 현재 객체의 대기실에 있는 임의의 쓰레드에게 알림처리
    }
}
