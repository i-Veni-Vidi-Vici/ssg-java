package com.sh.thread._04.concurrent.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class App {
    public static void main(String[] args) {
//        NumberGenerator numberGenerator = new NumberGenerator();
        AtomicNumberGenerator numberGenerator = new AtomicNumberGenerator();

        int nThread = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(nThread);
        for(int i = 0 ; i < nThread ; i++){
            executorService.submit(() -> System.out.println(Thread.currentThread().getName() + " : " + numberGenerator.nextN()));
        }
        executorService.shutdown();
    }

    static class NumberGenerator{
        private  Integer n = 0;

        public Integer nextN(){
            return n++;
        }
    }

    static class AtomicNumberGenerator{
        private AtomicInteger atomicInteger = new AtomicInteger();

        public Integer nextN(){
            return atomicInteger.incrementAndGet();
        }
    }
}
