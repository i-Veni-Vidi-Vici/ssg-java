package com.sh.thread._02.synchronizatic.withdraw;

/**
 * 동기화
 * 임계영역
 * 교착상태
 *
 * 동기화처리(저수준)
 * 1. synchronized 메소드 : 해당객체가 임계영역으로 지정되고 락을 획득한 하나의 쓰레드만 접근허용
 * 2. synchronized 블럭 : 지정한 객체가 임계영역으로 지정되고, 락을 획득한 하나의 쓰레드만 접근허용
 * - 공정성이 없는 방식이다. 기아 상태의 쓰레드가 나올 수 있다.
 */
public class App {
    public static void main(String[] args) {

    }
}
