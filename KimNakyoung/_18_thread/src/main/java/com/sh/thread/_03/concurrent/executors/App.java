package com.sh.thread._03.concurrent.executors;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiFunction;

/**
 *
 * <pre>
 *  Executors API는 쓰래드의 생성, 종료등의 작업을 위임에서 처리하는 기능이다.
 *  사용자는 실제 할일 (Runnable구현클래스)만 작성하면 된다.
 *
 *
 *
 *  Executors.newFixedThreadPool(nThread:int)
 *  - 고정된 개수의 쓰레드를 자동으로 생성하고 관리해주는 기능
 *  - 동시에 일어나는 업무량이 고정적인 경우
 *
 * </pre>
 *
 */


public class App {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

//        executorService.submit(() -> System.out.println(Thread.currentThread().getName()));
//        executorService.submit(() -> System.out.println(Thread.currentThread().getName()));
//        executorService.submit(() -> System.out.println(Thread.currentThread().getName()));
//        executorService.submit(() -> System.out.println(Thread.currentThread().getName()));
//        executorService.submit(() -> System.out.println(Thread.currentThread().getName()));
//
        //계산 기능 처리하기 : 숫자 2개를 입력하면 그 합을 출력하는 메소드
        BiFunction<Integer,Integer,Runnable> function =
//                ( n1,n2) -> {
//                    return () -> System.out.println(Thread.currentThread().getName() + " " + n1 + " " + n2 + "=" + (n1 + n2));
//                };
                ( n1,n2) -> () -> System.out.println(Thread.currentThread().getName() + " " + n1 + " " + n2 + "=" + (n1 + n2));
            // 람다에 무슨 화살표가 두개있어? 이상하게 보여.. 하지만 익숙해져야함 첫번째꺼 기준으로 잘라야 한다. n1,n2기준으로 반환한다.

        executorService.submit((function.apply(10,20))); // function은 들어올 수 없다. runnable은 가능
        executorService.submit((function.apply(20,30))); // function은 들어올 수 없다. runnable은 가능
        executorService.submit((function.apply(30,40))); // function은 들어올 수 없다. runnable은 가능
        executorService.submit((function.apply(40,50))); // function은 들어올 수 없다. runnable은 가능

        executorService.shutdown(); // 마지막에 꼭 셧다운 해줘야함 이거 안해주면 할일 기다리고 있음


    }
}
