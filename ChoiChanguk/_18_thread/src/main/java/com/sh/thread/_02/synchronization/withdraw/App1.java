package com.sh.thread._02.synchronization.withdraw;

/**
 * <pre>
 * 동기화 synchronization
 * - 쓰레드간 공유자원에 대해 작업순서를 지정하는 것
 * - 동기화의 사전적의미는 타이밍을 맞춘다는 뜻으로, 한 쓰레드의 작업완료와,
 *   다음 쓰레드의 작업시작을 맞추는 것이다.
 * - 재부적으로는 특정객체의 락을 획득.반환 처리하는 방식으로 이루어진다.
 *
 * 임계영역 critical-section
 * - 멀티쓰레드 환경에서 한 번에 하나씩 쓰레드만 접근해야 하는 공유자원
 * - 한 쓰레드의 작업이 시작되고, 마칠때까지 다른 쓰레드의 의해 방해받지 않도록 동기화 처리가 필요
 * - 임계영역은 적을 수록 멀티쓰레드환경에서 성능이 좋다
 *
 * 교착상태 deal-lock
 * - 두 개이상의 공유자원을 멀티쓰레드에서 베타적으로 확보한 상태를 얘기한다.
 * - 공유자원이 A, B일 때, "가" 쓰레드는 A를 확보, "나"쓰레드는 B를 확보한 후, 서로의 공유자원을 기다리는 상태
 * - 공유자원 A,B를 묶어서 임계영역을 지정해서 처리해야 한다  A,B가 아니라 A+B인 상태이다
 *
 * 동기화처리 (저수준)
 * 1. synchronized 메소드 : 해당객체가 임계영역으로 지정되고 락을 획득한 하나의 쓰레드만 접근을 허용
 * 2. synchronized 블럭 : 지정한 객체가 임계영역으로 지정되고, 락을 획득한 하나의 쓰레드만 접근허용
 * 문제점 : 공정성이 없는 방식이다, 기아상태의 쓰레드가 나올 수 있다.
 * </pre>
 */
public class App1 {
    /**
     * 1번 계좌(공유자원)로부터 출금하는 멀티쓰레드 예제
     * @param args
     */
    public static void main(String[] args) {

        Account account = new Account("홍길동", 1_000);
        Thread atm1=new Thread(new ATM(account),"atm1");
        Thread atm2=new Thread(new ATM(account),"atm2");
        atm1.start();
        atm2.start();

    }

}
