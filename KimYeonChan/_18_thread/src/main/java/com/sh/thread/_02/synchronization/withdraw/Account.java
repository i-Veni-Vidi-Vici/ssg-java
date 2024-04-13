package com.sh.thread._02.synchronization.withdraw;

public class Account {
    private String name;
    private long balance;

    public Account(String name, long balance) {
        this.name = name;
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    /**
     * synchronized 메소드: this 객체를 임계영역으로 지정
     * synchronized 블럭: 지정한 객체를 임게영역으로 지정(this, 특정필드, static)
     *   - 메소드 대비 좀더 적은 범위로 지정 가능
     * @param money
     */
    public void whthdraw(int money) {
        synchronized (this) {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + "출금시도: 잔액 " + this.balance + "원, 출금액: " + money + "원");
            if (this.balance >= money) {
                balance -= money;
                System.out.println("출금결과 잔액: " + (balance) + "원");
            }
            else {
                System.out.println("> 잔액 부족");
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
