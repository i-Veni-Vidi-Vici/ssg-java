package com.sh.thread._05.concurent.synchronizers.semaphore;

public class ATM implements Runnable {
    private Account account;
    public ATM(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        while (this.account.getBalance() > 0) { // 꺼낼 돈이 있으면 계속 돌아라!
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int money = (int) (Math.random() * 3 + 1) * 100; //100 200 300원 중 하나 출력
            account.withdraw(money);

        }
    }
}
