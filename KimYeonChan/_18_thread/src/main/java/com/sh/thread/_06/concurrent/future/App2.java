package com.sh.thread._06.concurrent.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 *  CompletableFuture.runAsync(Runnable): CompletableFuture<void>
 *  CompletableFuture.supplyAsync(Supplier<T>): CompletableFuture<T>
 *  - ExecutorService 의 구현 클래스
 *  - jdk7 부터 지원하는 ForkJoinPool 의 commonPool(ExecutorService 의 구현 클래스) 로부터 스레드를 가져와 작업진행
 *  - 비동기작업 결과를 연달아 처리할 수 있는 메소드 등을 제공한다.
 *  - ForkJoinPool 은 작업을 여러 스레드간에 분할/병합 방식으로 처리하는 성능 좋은 스레드풀이다. 
 */
public class App2 {
    public static void main(String[] args) {
//        CompletableFuture.runAsync(() -> System.out.println(Thread.currentThread().getName()));
//        for (int i = 0; i < 10_000; i++) {
//            System.out.print("");
//        }
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello World";
        }).thenApply((str) -> str.toUpperCase());

        try {
            System.out.println(completableFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
