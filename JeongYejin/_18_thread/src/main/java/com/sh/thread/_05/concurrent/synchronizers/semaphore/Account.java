package com.sh.thread._05.concurrent.synchronizers.semaphore;

import java.util.concurrent.Semaphore;

public class Account {
    private Semaphore semaphore = new Semaphore(1, true);
    // 허용할 쓰레드 수와 공정성 여부 지정
    // 세마포어가 임계영역을 지정하는 객체이다.
    private String name;
    private long balance;

    public Account(String name, long balance) {
        this.name = name;
        this.balance = balance;
    }

    public void withdraw(int money) {
        try {
            semaphore.acquire(); // 임계영역 시작
            // 작업코드
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " 출금시도 : 잔액 " + this.balance + "원, 출금액 : " + money + "원");
            if (this.balance >= money) {
                balance -= money;
                System.out.println(threadName + " 출금결과 : 잔액 " + this.balance + "원");
            } else {
                System.out.println(threadName + " 출금실패 : 잔액부족.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release(); // 임계영역 해제
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
