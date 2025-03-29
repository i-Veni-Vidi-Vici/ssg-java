package com.sh.thread._02.synchronization.withdraw;

public class ATM implements Runnable {
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
            int money = (int)(Math.random() * 3 + 1) * 100; // 100, 200, 300
            account.whthdraw(money);
        }
    }
}
