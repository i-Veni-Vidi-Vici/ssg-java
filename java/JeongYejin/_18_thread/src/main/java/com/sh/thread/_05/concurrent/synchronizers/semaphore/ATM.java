package com.sh.thread._05.concurrent.synchronizers.semaphore;

public class ATM extends Thread {
    private Account account;
    public ATM(Account account) {
        this.account = account;
    }
    @Override
    public void run() {
        while (this.account.getBalance() > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int money = (int)(Math.random() * 3 + 1) * 100; // 100 200 300 중 하나
            account.withdraw(money);
        }
    }
}