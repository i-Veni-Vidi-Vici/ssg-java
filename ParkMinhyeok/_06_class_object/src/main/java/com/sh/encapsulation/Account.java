package com.sh.encapsulation;

/**
 * <pre>
 * 은행계좌 사용자 자료형
 * - name: String
 * - balance: long
 * </pre>
 */
public class Account {
    String name;
    long balance; // 잔액

    /**
     * 입금메소드
     */
    public void deposit(int money) {
        // 유효성검사
        if(money <= 0) {
            System.out.println("유효한 입금액이 아닙니다.");
            return; // 조기리턴
        }

        // 입금처리
        balance += money;
    }

    /**
     * 출금 메소드
     */
    public void withdraw(int money) {
        // 유효성 검사1 - 0, 음수가 아니어야 한다.
        if(money <= 0){
            System.out.println("유효한 출금액이 아닙니다. - " + money + "원");
            return;
        }
        // 유효성 검사2 - 잔액과 같거나 작은 금액을 출금해야 한다.
        if(money > balance) {
            System.out.println("잔액이 부족합니다. - " + money + "원");
            return;
        }

        // 출금 처리
        balance -= money;
    }
}
