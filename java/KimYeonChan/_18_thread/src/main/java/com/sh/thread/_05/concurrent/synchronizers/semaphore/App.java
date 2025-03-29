package com.sh.thread._05.concurrent.synchronizers.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  Semaphore
 *  - 허용된 자업수를 제한하는 타입
 *  - 공정성(먼저 접근한 스레드가 먼저 작업권을 획들할 수 있음)을 보장할 수 있는 기능
 */
public class App {
    public static void main(String[] args) {
        Account account = new Account("홍길동", 1_000);
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(new ATM(account));
        executorService.submit(new ATM(account));

        executorService.shutdown();
    }
}
