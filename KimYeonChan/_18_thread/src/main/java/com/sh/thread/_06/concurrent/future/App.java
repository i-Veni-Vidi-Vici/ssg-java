package com.sh.thread._06.concurrent.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *  Future
 *  - 스레드에 할당된 비동기 작업의 리턴객체
 *  - 작업결과물을 반환받을 수 있다.
 *  - 저수준 API 에서는 스레드 실행결과를 반환 받는 기능이 없다.
 */
public class App {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // ExecutorService#execute(Runnable):void 비동기 작업 리턴값 없음
//        executorService.execute(() -> {
//            try {
//                Thread.sleep(3_000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("Zzz...");
//        });
        // ExecutorService#submit(Callable) 비동기 작업 리턴값 있음
        // ExecutorService#submit(Callable<String>):Future<String>
        Future<String> future = executorService.submit(() -> {
            try {
                Thread.sleep(3_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello World";
        });

        // 메인 스레드 작업...
        System.out.println("작업중...");

        // 스레드 결과값 가져오기
        try {
            System.out.println(future.get()); // 블럭 처리
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();
        System.out.println("main 스레드 종료");
    }
}
