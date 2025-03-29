package com.sh.thread._03.concurrent.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <pre>
 *
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(()-> System.out.println(Thread.currentThread().getName()));
        executorService.submit(()-> System.out.println(Thread.currentThread().getName()));
        executorService.submit(()-> System.out.println(Thread.currentThread().getName()));
//        pool-1-thread-1
//        pool-1-thread-1
//        pool-1-thread-1
        executorService.shutdown();
    }
}
