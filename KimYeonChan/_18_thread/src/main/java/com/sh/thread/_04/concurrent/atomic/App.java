package com.sh.thread._04.concurrent.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 채번예제
 * - 멀티 스레드 환경에서 각 스레드별로 고유한 번호를 가져가길 원하는 경우
 * - Atomic 클래스를 통해 쉽게 동기화 처리가 가능하다. (블럭 방식이 아닌 CAS 알고리즘에 처리되어 성능이 좋다.)
 */
public class App {
    public static void main(String[] args) {
        AtomicNumberGenerator atomicNumberGenerator = new AtomicNumberGenerator();

        int nThread = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(nThread);

        for (int i = 0; i < nThread; i++) {
            executorService.submit(() -> System.out.println(Thread.currentThread().getName() + ": " + atomicNumberGenerator.nextN()));
        }

        executorService.shutdown();
    }

    static class NumberGenerator {
        private Integer n = 0;

        public  Integer nextN() {
            return  ++n;
        }
    }

    static class AtomicNumberGenerator {
        private AtomicInteger atomicInteger = new AtomicInteger();

        public  Integer nextN() {
            return  atomicInteger.incrementAndGet();
        }
    }
}
