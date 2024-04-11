package com.sh.thread._03.concurrent.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiFunction;

/**
 * <pre>
 *      Executors API 는 스레드의 생성, 종료 등의 작업을 위임해서 처리하는 기능이다.
 *      사용자는 실제 할 일 Runnable 구현 클래스만 작성하면 된다.
 *
 *      Executor.newFixedThreadPool(nThread:int)
 *      - 고정된 개수의 스레드를 자동으로 생성하고 관리해주는 기능
 *      - 동시에 일어나는 업무량이 고정적인 경우
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

//        executorService.submit(() -> System.out.println(Thread.currentThread().getName()));
//        executorService.submit(() -> System.out.println(Thread.currentThread().getName()));
//        executorService.submit(() -> System.out.println(Thread.currentThread().getName()));
//        executorService.submit(() -> System.out.println(Thread.currentThread().getName()));
//        executorService.submit(() -> System.out.println(Thread.currentThread().getName()));

        // 계산 기능 처리하기: 숫자 2개를 입력하면 그 합을 출력하는 메소드
        BiFunction<Integer, Integer, Runnable> function =
//                (n1, n2) -> {
//                    return () -> System.out.println(Thread.currentThread().getName() + " " + n1 + " + " + n2 + " = " + (n1 + n2));
//                };
                (n1, n2) -> () -> System.out.println(Thread.currentThread().getName() + " " + n1 + " + " + n2 + " = " + (n1 + n2));
        executorService.submit(function.apply(10, 20));
        executorService.submit(function.apply(20, 30));
        executorService.submit(function.apply(30, 40));
        executorService.submit(function.apply(40, 50));

        executorService.shutdown();
    }
}
