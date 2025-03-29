package com.sh.thread._02.synchronization.bakery;

public class Plate {
    private  int breadNo;   //생성한 빵번호
    private boolean empty = true;   //접시가 비었는지 여부
    //true면 빵이 없음   //false면 빵이 있음

    /**
     * 손님 쓰레드용 메소드
     */
    public synchronized void eatBread(){
        while(this.empty){
            try {
                wait();
            } catch (InterruptedException e) {
                break;
            }
        }
        System.out.println("[손님] " + breadNo + "번 빵을 먹었습니다.");
        this.empty = true;
        notify();   //waiting중인 요리사 쓰레드에게 알림
    }

    /**
     * 요리사 쓰레드용 메소드
     */
    public synchronized void makeBread(int breadNo){
        while(!this.empty) {
            //접시가 비어 있지 않다면
            try {
                wait();
            } catch (InterruptedException e) {
                break;
            }
        }
        System.out.println("[요리사]" + breadNo + "번 빵을 만들었습니다.");
        this.breadNo = breadNo;
        this.empty = false;
        notify();// 빵을 기다리는 손님 쓰레드 위해서 notify -> 현재객체의 대기실에 있는 임의의 쓰레드에게 알람처리
    }
}
