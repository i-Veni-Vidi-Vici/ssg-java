package com.sh.thread._02.synchronization.withdraw;

public class Account {
    private String name;
    private long balance;

    public Account(String name, long balance) {
        this.name = name;
        this.balance = balance;
    }


    public long getBalance() {
        return this.balance;
    }

    /**
     * <pre>
     *     1. synchronized 메소드 : this 객체를 임계 영역으로 지정
     *     2. sychronized 블럭 : 지정한 객체를 임계영역으로 지정(this, 특정 필드, static)
     *      - 메소드 대비 좀 더 적은 범위로 지정 가능
     * </pre>
     * @param money
     */
    public /*synchronized*/ void withdraw(int money) {
        //괄호 안에 지정한 객체를 임계 영역으로 지정함
        synchronized (this) {

        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " 출금 시도 : 잔액 " + this.balance + "원, 출금액 " + money + "원");
        if (this.balance >= money) {
            balance -= money;
            System.out.println(threadName + " 출금 결과 : 잔액 " + this.balance + "원");
        }
        else {
            System.out.println(threadName + " 출금 실패 : 잔액 부족!");
        }
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
