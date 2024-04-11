package com.sh.thread._05.concurrent.synchronizers.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) {
        Account account = new Account("홍길동", 1_000);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new ATM(account));
        executorService.submit(new ATM(account));
        executorService.shutdown();
    }
}
