package com.sh.thread._05.concurrent.synchronizers.semaphore;

import java.util.concurrent.Semaphore;

public class Account {

    private Semaphore semaphore = new Semaphore(1,true); // 기본값은 false // 먼저들어온애가 다음락을 들어올수있게끔
    // 허용할 쓰레드 수 ,

    private String name;
    private long balance;
    public Account(String name, long balance) {
        this.name = name;
        this.balance = balance;
    }

    public long getBalance() {
        return this.balance;
    }


    public void withdraw(int money){

        try {
            semaphore.acquire(); // 임계영역 시작
            // 작업코드
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " 출금시도 : 잔액 " + this.balance + "원, 출금액 : " + money + "원");
            if(this.balance >= money) {
                balance -= money;
                System.out.println(threadName + " 출금결과 : 잔액 " + this.balance + "원");
            }
            else {
                System.out.println(threadName + " 출금실패 : 잔액부족!!!");
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release(); // 임계영역 해제
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
