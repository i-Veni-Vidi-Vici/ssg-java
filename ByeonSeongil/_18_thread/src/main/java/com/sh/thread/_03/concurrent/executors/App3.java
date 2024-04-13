package com.sh.thread._03.concurrent.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <pre>
 * Executors.newSingleThreadExecutor()
 * - 단일쓰레드를 생성해서 제공.
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.submit(() -> System.out.println(Thread.currentThread().getName()));
        executorService.submit(() -> System.out.println(Thread.currentThread().getName()));
        executorService.submit(() -> System.out.println(Thread.currentThread().getName()));

        executorService.shutdown();
    }
}
