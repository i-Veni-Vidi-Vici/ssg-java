package com.sh.thread._04.concurrent.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <pre>
 * 채번예제
 * - 멀티쓰레드 환경에서 각 쓰레드별로 고유한 번호를 가져가길 원하는 경우
 * - Atomic클래스를 통해 쉽게 동기화처리가 가능하다. (블럭방식이 아닌 CAS알고리즘에 처리되어 성능이 좋다)
 * </pre>
 */
public class App {
    public static void main(String[] args) {
//        NumberGenerator numberGenerator = new NumberGenerator();
        AtomicNumberGenerator numberGenerator = new AtomicNumberGenerator();

        int nTread = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(nTread);
        for(int i = 0; i < nTread; i++) {
            executorService.submit(() -> System.out.println(Thread.currentThread().getName() + " : " + numberGenerator.nextN()));
        }
        executorService.shutdown();
    }

    static class NumberGenerator {
        private Integer n = 0;
        public Integer nextN() {
            return ++n;
        }
    }

    static class AtomicNumberGenerator {
//        private AtomicInteger aotmicInteger = new AtomicInteger();
        private AtomicInteger aotmicInteger = new AtomicInteger(0);
        public Integer nextN() {
            return aotmicInteger.incrementAndGet();
        }
    }
}
