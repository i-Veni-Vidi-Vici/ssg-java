package com.sh.thread._03.concurrent.executors;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App4 {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        // n초 뒤에 작업 실행
        scheduledExecutorService.schedule(()-> System.out.println("Helloworld"), 3, TimeUnit.SECONDS);
        // m 초 간격으로 작업 실행
        scheduledExecutorService.scheduleAtFixedRate(()-> System.out.println(LocalTime.now()),  5, 1, TimeUnit.SECONDS);
        System.out.println("12345");

        //일정 간격 이후 executors 종료
        try {
            Thread.sleep(10*1000);
            scheduledExecutorService.shutdown();
//            scheduledExecutorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //scheduledExecutorService.shutdown();
    }
}
