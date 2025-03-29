package com.sh.thread._04.concurent.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <pre>
 *
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        NumberGenerator numberGenerator = new NumberGenerator();
        int nThread = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(nThread);

        for (int n = 0; n < nThread; n++) {
            executorService.submit(() -> System.out.println(Thread.currentThread().getName() + " : " + numberGenerator.nextN()));
        }
        executorService.shutdown();
    }


    static class NumberGenerator {
        private Integer n = 0;

        private Integer nextN() {
            return ++n;
        }
    }

    static class AtomicNumberGenerator {
        private AtomicInteger atomicInteger = new AtomicInteger(0);

        public Integer nextN() {
            return atomicInteger.incrementAndGet();
        }
    }
}
