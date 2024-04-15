package com.sh.thread._06.concurent.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        //ExecutorService#execute(Runnable) : void 비동기 작업 리턴값 없음
//        executorService.execute(() -> {
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("ㅋㅋㅋㅋㅋ");
//        });

        //ExecutorService#submit(Callable) : 비동기 작업 리턴값 있음
        //ExecutorService#submit(Callable<String>) : Future<String>
        // 미래의 쓰레드 작업결과 반환 값을 가진 객체


        Future<String> future = executorService.submit(() -> {
            try {
                Thread.sleep((int) (Math.random() * 3 + 3) * 1000); //3초, 4초, 5초
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Hello world";
        });

        //메인 쓰레드 작업 지속..
        System.out.println("🥗🥙🥪🌮");
        System.out.println("🥗🥙🥪🌮");
        System.out.println("🥗🥙🥪🌮");


        try {
            //쓰레드의 결과값 가져오기
            String value = future.get();// 블럭 처리
            System.out.println(value);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }


        executorService.shutdown();
        System.out.println("main thread 종료..");
    }
}
