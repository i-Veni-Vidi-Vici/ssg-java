package com.sh.thread._02.synchronization.withdraw;

/**
 * <pre>
 * ### 동기화 synchronazation
 * - 쓰레드간 공유 자원에 대해 작업 순서를 지정하는 것
 * - 동기화의 사전적 의미는 타이밍을 맞춘다는 뜻으로, 한 쓰레드의 작업 완료, 다음 쓰레드의 작업 시작을 맞추는 것
 * - 내부적으로는 특정 객체의 락을 획득/반환 처리 하는 방식으로 이뤄짐
 *
 * ### 임계 영역 critical-section
 * - 멀티 쓰레드 환경에서 한번에 하나의 쓰레드만 접근해야 하는 공유 자원
 * - 한 쓰레드의 작업이 시작되고, 마칠때까지 다른 쓰레드에 의해 방해받지 않도록 동기화 처리가 필요
 * - 임계영역은 적을수록 멀티쓰레드 환경에서 성능이 좋음
 *
 * ### 교착 상태 dead - lock
 * - 두 개 이상의 공유 자원을 멀티 쓰레드에서 배타적으로 확보한 상태를 얘기함
 * - 공유 자원이  A, B 일 때, “가” 쓰레드는 A를 확보, “나” 쓰레드는 B를 확보한 후, 서로의 공유 자원을 기다리는 상태
 * - 공유 자원 A, B를 묶어서 임계 영역으로 지정해서 처리해야 함
 * </pre>
 */
public class App {
    /**
     * <pre>
     *     한 계좌(공유 자원)로부터 출금하는 멀티 쓰레드 예제
     * </pre>
     */
    public static void main(String[] args) {
        Account account = new Account("홍길동", 1_000);
        Thread atm1 = new Thread(new ATM(account), "atm1");
        Thread atm2 = new Thread(new ATM(account), "atm2");
        atm1.start();
        atm2.start();
    }
}
