package com.sh.thread._06.concurrent.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

//        ExecutorService#execute(Runnale)  비동기 작업 리턴 값 없음
//        executorService.execute(()->{
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("엄준식");
//        });


//        ExecutorService#submit(Callable) 비동기 작업 리턴 값 있음
        Future<String> future = executorService.submit(()->{
            try {
                Thread.sleep((int)(Math.random()*3+1) * 1000);  //1초, 2초, 3초
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Hello World";
        });
        //메인쓰레드 작업 지속...
        System.out.println("메인은 할일을 한다");
        System.out.println("메인은 할일을 한다");
        System.out.println("메인은 할일을 한다");

        //쓰레드 결과 값 가져오기
        try {
            String value = future.get();
            System.out.println(value);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();
        System.out.println("main 쓰레드 종료");
    }
}
