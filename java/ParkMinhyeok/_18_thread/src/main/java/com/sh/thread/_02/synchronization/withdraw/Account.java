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
     * 1. synchronized 메소드
     * </pre>
     * @param money
     */
    public synchronized void withdraw(int money) {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + "출금시도 : 잔액 " + this.balance + "원, 출금액 : " + money + "원");
        if (this.balance >= money) {
            balance -= money;
            System.out.println(threadName + "출금결과 : 잔액 " + this.balance + "원");
        } else {
            System.out.println("> 잔액부족!!!");
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
