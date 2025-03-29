package com.sh.thread._03.concurrent.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * <pre>
 *
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 2; i++) {
            final int n = i;
            //Variable used in lambda expression should be final or effectively final
            //함수형 프로그래밍에서 함수(람다) 불변이어야 함
            executorService.submit(() -> System.out.println(Thread.currentThread().getName() + "  작업" + n));
        }

        //1분 대기후, 제거된 쓰레드 확인
        System.out.println(((ThreadPoolExecutor) executorService).getPoolSize());
        try {
            Thread.sleep(61 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(((ThreadPoolExecutor) executorService).getPoolSize());

        executorService.shutdown();

    }
}
