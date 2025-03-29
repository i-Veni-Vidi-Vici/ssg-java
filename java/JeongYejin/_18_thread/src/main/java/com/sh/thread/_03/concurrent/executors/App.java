package com.sh.thread._03.concurrent.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiFunction;

/**
 * <pre>
 * Executors API는 쓰레드의 생성, 종료 등의 작업을 위임해서 처리하는 기능이다.
 * 사용자는 실제 할 일(Runnable 구현클래스 - 람다식)만 작성하면 된다.
 *
 * Executors.newFixedThreadPool(nThread:int)
 * - 고정된 개수의 쓰레드를 자동으로 생성하고 관리해주는 기능
 * - 동시에 일어나는 업무량이 고정적인 경우
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        // Executors, ExecutorService 다 구현체임

//        executorService.submit(() -> System.out.println(Thread.currentThread().getName()));
//        executorService.submit(() -> System.out.println(Thread.currentThread().getName()));
//        executorService.submit(() -> System.out.println(Thread.currentThread().getName()));
//        executorService.submit(() -> System.out.println(Thread.currentThread().getName()));
//        executorService.submit(() -> System.out.println(Thread.currentThread().getName()));

        // 계산 기능 처리하기 : 숫자 2개를 입력하면 그 합을 출력하는 메소드
        BiFunction<Integer, Integer, Runnable> function =
//                (n1, n2) -> {
//                    return () -> System.out.println(Thread.currentThread().getName() + " " + n1 + " + " + n2 + " = " + (n1 + n2));
//                };
                (n1, n2) -> () -> System.out.println(Thread.currentThread().getName() + " " + n1 + " + " + n2 + " = " + (n1 + n2));

        // Function 람다를 실행했는데, Runnable 람다를 뱉어주는 구조
        executorService.submit(function.apply(10, 20));
//        executorService.submit(() -> System.out.println(Thread.currentThread().getName() + " " + n1 + " + " + n2 + " = " + (n1 + n2)));
        executorService.submit(function.apply(20, 30));
        executorService.submit(function.apply(30, 40));
        executorService.submit(function.apply(40, 50));

        // executorService 가 종료가 안되니까 프로그램이 종료가 안된다
        // 프로그램 실행 -> 프로세스 시작 -> 쓰레드 실행 -> 프로세스 끝 -> 프로그램 끝
        executorService.shutdown();
    }
}
