package com.sh.thread._06.concurrent.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * <pre>
 * CompletableFuture.runAsync(Runnable): CompletableFuntion<Void>
 * CompletableFuture.runAsync(Supplier<T>): CompletableFuntion<T>
 * - ExecutorService의 구현클래스.
 * - jdk7부터 지원하는 ForkJoinPool의 commonPool로부터 쓰레드를 가져와 작업진행
 * - 비동기작업 결과를 연달아 처리할 수 있는 메소드 등을 제공한다.
 * - ForkJoinPool은 작업을 여러 쓰레드간에 분할/병합 방식으로 처리하는 성능좋은 쓰레드풀이다.
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        CompletableFuture<Void> voidCompletableFuture =
        CompletableFuture.runAsync(() -> System.out.println("Thread" + Thread.currentThread().getName()));
        try {
            voidCompletableFuture.get();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName());

//        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> System.out.println(Thread.currentThread().getName()));
//
//        for (int i = 0; i < 10_000; i++) {
//            System.out.print("");
//        }

        CompletableFuture<String> stringCompletableFuture =
                CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return "hello world";
                }).thenApply((str) -> str.toUpperCase());
        try {
            System.out.println(stringCompletableFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName());
    }
}