package com.sh.thread._03.concurrent.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *  <pre>
 *      Executors.newSingleThreadScheduleExecutor()
 *      - n초 뒤 작업실행, m초 간격으로 반복 실행 등을 수행하는 Executor
 *  </pre>
 */
public class App4 {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        // n초 뒤에 작업 실행
        scheduledExecutorService.schedule(() -> System.out.println("Hello World!"), 3, TimeUnit.SECONDS);

        // m초 간격으로 작업 실행
        scheduledExecutorService.scheduleAtFixedRate(() -> System.out.println("Hello World!"), 5, 1, TimeUnit.SECONDS);

        System.out.println("12345");

        try {
            Thread.sleep(10 * 1_000);
            scheduledExecutorService.shutdown();
            // 일정 간격 이후 executorService 만 종료
//            scheduledExecutorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
