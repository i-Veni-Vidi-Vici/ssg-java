package com.sh.thread._03.concurrent.executors;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * Executors.newSingleThreadScheduledExecutor()
 * - n초 뒤 작업실행, m초 간격을 작업 반복실행 등을 수행하는 Executor
 *
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        // ExecutorService의 자식 인터페이스

        // n초 뒤에 작업실행
        scheduledExecutorService.schedule(() -> System.out.println("Helloworld"), 3, TimeUnit.SECONDS);
        System.out.println("12345"); // 이게 먼저 찍힘

        // m초 간격으로 작업 실행
        scheduledExecutorService.scheduleAtFixedRate(() -> System.out.println(LocalDateTime.now()), 5, 1, TimeUnit.SECONDS);

//        scheduledExecutorService.shutdown();

        try {
            scheduledExecutorService.awaitTermination(10, TimeUnit.SECONDS);
            // 일정간격이후 executorService만 종료
            scheduledExecutorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
