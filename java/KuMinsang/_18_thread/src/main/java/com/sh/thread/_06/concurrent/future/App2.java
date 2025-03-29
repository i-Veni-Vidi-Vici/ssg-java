package com.sh.thread._06.concurrent.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class App2 {
    public static void main(String[] args) {
//        CompletableFuture<Void> voidCompletableFuture =
//            CompletableFuture.runAsync(() ->System.out.println(Thread.currentThread().getName()));
//        try {
//            voidCompletableFuture.get();
//        } catch (InterruptedException | ExecutionException e) {
//            throw new RuntimeException(e);
//        }
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Hello world";
        }).thenApply((str) -> str.toUpperCase());

        try {
            System.out.println(completableFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName());

    }
}
