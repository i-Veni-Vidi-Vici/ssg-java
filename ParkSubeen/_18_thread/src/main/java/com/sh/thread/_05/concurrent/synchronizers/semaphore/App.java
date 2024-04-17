package com.sh.thread._05.concurrent.synchronizers.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <pre>
 * Semaphore
 * - 허용된 작업수를 제한하는 타입.
 * - 공정성(먼저 접근한 쓰레드가 먼저 작업권을 획득할 수 있음)을 보장할 수 있는 기능
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        Account account = new Account("홍길동", 1_000);
//        Thread atm1 = new Thread(new ATM(account), "atm1");

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new ATM(account));
        executorService.submit(new ATM(account));

        executorService.shutdown();
    }
}
