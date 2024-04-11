package com.sh.thread._02.synchronization;

/**
 * <pre>
 * 동기화 synchronization
 * 
 * 임계영역 critical-section
 * - 멀티쓰레드 환경에서 한번에 하나의 쓰레드만 접근해야 하는 공유자원 
 * 
 * 교착상태 dead-lock
 *
 * </pre>
 */
public class App {
    /**
     * <pre>
     *     한 계좌로부터 출금하는 멀티 쓰레드 예제
     *     1. synchronized 메소드
     * </pre>
     */
    public static void main(String[] args) {
        Account account  = new Account("홍길동", 1_000);
        Thread atm1 = new Thread(new ATM(account), "atm1");
        Thread atm2 = new Thread(new ATM(account), "atm2");
        atm1.start();
        atm2.start();

    }
}
