package com.sh.thread._02.synchronization.withdraw;

public class Account {
    private String name;
    private long balance;
    public Account(String name, long balance) {
        this.name = name;
        this.balance = balance;
    }

    /**
     * <pre>
     * 1. synchronized 메소드 : this객체를 임계영역으로 지정
     * 2. synchronized 블럭 : 지정한 객체를 임계영역으로 지정(this, 특정필드, static) 메소드대비 좀더 적은 범위로 지정이 가능
     * </pre>
     * @param money
     */
    public /*synchronized*/ void withdraw(int money) {
        // 지정한 객체를 임계영역으로 지정한다.
        synchronized (this) {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + "출금시도 : 잔액 " + this.balance + "원, 출금액 : " + money + "원");
            if (this.balance >= money) {
                balance -= money;
                System.out.println(threadName + "출금결과 : 잔액 " + this.balance + "원");
            }
            else {
                System.out.println(threadName + "출금실패 : 잔액부족!");
            }
        }

    }

    public long getBalance() {
        return this.balance;
    }

    @Override
    public String toString() {
        return "Accout{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
