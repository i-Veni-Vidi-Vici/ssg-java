package com.sh.thread._02.synchronization.withdraw;

/**
 * 동기화 synchronization
 *  - 쓰레드간 공유자원에 대해 작업 순서를 지정하는 것이다.
 *  - 동기화의 사전적 의미는 타이밍을 맞춘다는 뜻으로, 한쓰레드의 작업완료, 다음 쓰레드의 작업시작을 맞추는 것이다.
 *  - 내부적으로는 특정객체의 락을 획득/반환 처리하는 방식으로 이루어진다.
 * 임계영역 critical-section
 *  - 멀태쓰레드 환경에서 한번에 하나의 쓰레드만 접근해야하는 공유자원
 *  - 한쓰레드의 작업이 시작되고, 마칠때까지 다른 쓰레드의 의해 방해 받지 않도록 동기화처리가 필요하다.
 *  - 임계영역은 적을 수록 멀티쓰레드 환경에서 성능이 좋다.
 * 교착상태 dead-lock
 *  - 두개 이상의 공유 자원을 멀티쓰레드에서 베타적으로 확보한 상태를 이야기한다.
 *  - 공유자원이 A, B일때, "가"쓰레드는 A를 확보, "나"쓰레드는 B를 확보한 후, 서로의 공유의 자원을 기다리는 상
 *  - 공유자원 A, B를 묶어서 임께영역으로 지정해서 처리해야 한다.
 * 동기화처리 (저수준)
 *  1. synchronized 메소드: 해당 객체가 임게영역으로 지정되고, 락을 획득한 하나의 쓰레드만 접근 허용
 *  2. synchronized 블럭: 지정한 객체가 임계영역으로 지정되고, 락을 획득한 하나의 쓰레드만 접근 허용
 *  - 공정성이 없는 방식이다. 기아상태의 쓰레드가 나올 수 있다.
 */
public class App {
    public static void main(String[] args) {
        Account account = new Account("홍길동", 1_000);
        Thread atm1= new Thread(new ATM(account), "atm1");
        Thread atm2= new Thread(new ATM(account), "atm2");
        atm1.start();
        atm2.start();
    }
}
