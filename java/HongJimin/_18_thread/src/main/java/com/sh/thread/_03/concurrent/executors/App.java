package com.sh.thread._03.concurrent.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiFunction;

public class App {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

//        executorService.submit(() -> System.out.println(Thread.currentThread().getName()));
//        executorService.submit(() -> System.out.println(Thread.currentThread().getName()));
//        executorService.submit(() -> System.out.println(Thread.currentThread().getName()));
//        executorService.submit(() -> System.out.println(Thread.currentThread().getName()));
//        executorService.submit(() -> System.out.println(Thread.currentThread().getName()));

        //계산 기능 처리하기 : 숫자 2개를 입력하면, 그 합을 출력하는 메소드
        BiFunction<Integer, Integer, Runnable> function =
//        (n1, n2) -> {
//            return () -> System.out.println(Thread.currentThread().getName() + " " + n1 + " + " + n2 + " = " + (n1 + n2));
//        };
                (n1, n2) -> () -> System.out.println(Thread.currentThread().getName() + " " + n1 + " + " + n2 + " = " + (n1 + n2));

        executorService.submit(function.apply(10, 20));
        executorService.submit(function.apply(20, 30));
        executorService.submit(function.apply(30, 40));
        executorService.submit(function.apply(40, 50));

        executorService.shutdown();
    }
}
