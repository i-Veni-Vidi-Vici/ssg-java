package com.sh.thread._06.concurrent.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * <pre>
 * Future
 * - 쓰레드에 할당된 비동기 작업의 리턴객체
 * - 작업결과물을 반환받을 수 있다.
 * - 저수준 API에서는 쓰레드 실행결과를 반환받는 기능이 아예 없었다. concurrent API에서만 가능하다.
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // ExecutorService#execute(Runnable) 비동기작업 리턴값 없음
        executorService.execute(() -> {
            try{
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // ExecutorService#submit(Callable) 비동기작업 리턴값 있음.
        // ExecutorService#submit(Callable<String>):Future<String>
        Future<String> future = executorService.submit(() -> {
            try {
                Thread.sleep((int)(Math.random() *3 +3) *1000); // 3초, 4초, 5초
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Hello world";
        });

        // 메인쓰레드 작업 지속...
        System.out.println("🍔🍟🌭");
        System.out.println("🍔🍟🌭");
        System.out.println("🍔🍟🌭");


        try {
            // 쓰레드의 결과값 가져오기
            String value = future.get(); // 블럭처리
            System.out.println(value);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }


        executorService.shutdown();
        System.out.println("main thread 종료...");
    }
}
