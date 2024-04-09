package com.sh.thread._02.synchronization;

public class Account {
    private int balance;
    private String name;

    public Account(String name, int balance) {
        this.name =name;
        this.balance = balance;
    }

    public long getBalance(){
        return this.balance;
    }

    public /*synchronized*/ void withdraw(int money){
        synchronized (this) {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + "출금시도 : 잔액 " + this.balance + "원, 출금액 : " + money + "원");
            if (this.balance >= money) {
                balance -= money;
                System.out.println(threadName + "출금결과 : 잔액 " + this.balance + "원");
            } else {
                System.out.println(threadName + "출금실패 : 잔액부족");
            }
        }
    }


    @Override
    public String toString() {
        return "Account{" +
                "name='"+name+"' balance="+balance;
    }
}
