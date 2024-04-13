package com.sh.thread._02.synchronization.withdraw;

/**
 *
 * <pre>
 *  동기화 synchronization
 *  - 쓰레드간 공유자원에 대해 작업순서를 지정하는 것
 *  - 동기화의 사전적의미는 타이밍을 맞춘다는 뜻으로, 한쓰레드의 작업완료, 다음쓰레드의 작업시작을 맞추는 것이다.
 *  - 내부적으로는 특정객체의 락을 획득/반환 처리하는 방식으로 이루어진다.
 *
 *  임계영역 critical-section
 *  - 멀티쓰레드 환경에서 한번에 하나의 쓰레드만 접근해야 하는 공유자원
 *  - 한쓰레드의 작업이 시작되고, 마칠때까지 다른쓰레드의 의해 방해받지 않도록 동기화처리가 필요하다.
 *  - 임계영역은 적을수록 멀티쓰레드환경에서 성능이 좋다. ( 기다림을 적게 만드는게 좋기때문에)
 *
 *  교착상태 dead-lock
 *  - 두개이상의 공유자원을 멀티쓰레드에서 배타적으로 확보한 상태를 얘기한다.
 *  - 공유자원이 A,B일때, "가" 쓰레드는 A를 확보, "나"쓰레드는 B를 확보한 후, 서로의 공유자원을 기다리는 상태
 *  - 공유자원 A,B를 묶어서 임계영역으로 지정해서 처리해야 한다.
 *
 *  동기화처리(저수준) - 직접처리가 저수준
 *  1. synchronized 메소드 : 해당객체가 임계영역으로 지정되고 락을 획득한 하나의 쓰레드만 접근허용
 *  2. synchronized 블럭 : 지정한 객체가 임계영역으로 지정되고, 락을 획득한 하나의 쓰레만 접근허용
 * - 공정성이 없는 방식이다. 기아상태의 쓰레드가 나올 수 있다.
 *
 *
 *
 * </pre>
 *
 */


public class App {
    /**
     *
     * <pre>
     *  한계좌(공유자원)로부터 출금하는 멀티쓰레드 예제
     * </pre>
     *
     * @param args
     */

    public static void main(String[] args) {
        Account account = new Account("홍길동",1_000);
        Thread atm1 = new Thread(new ATM(account), "atm1"); // runnable?
        Thread atm2 = new Thread(new ATM(account), "atm2"); // runnable?
        atm1.start();
        atm2.start();


    }
}
