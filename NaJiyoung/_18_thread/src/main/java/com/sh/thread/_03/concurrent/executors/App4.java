package com.sh.thread._03.concurrent.executors;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * Executors.newSingleThreadScheduledExecutor()
 * - n초 뒤 작업실행, n초간격을 작업 반복실행등을 수행하는 Executor
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        // n초 뒤에 작업실행
        scheduledExecutorService.schedule(() -> System.out.println("Helloworld"), 5, TimeUnit.SECONDS);

        // m초 간격으로 작업실행
        scheduledExecutorService.scheduleAtFixedRate(() -> System.out.println(LocalDateTime.now()), 5, 1, TimeUnit.SECONDS);

        System.out.println("12345");


        try {
            Thread.sleep(10 * 1000);
            scheduledExecutorService.shutdown();
            // 일정간격이후 executorService만 종료
//            scheduledExecutorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
