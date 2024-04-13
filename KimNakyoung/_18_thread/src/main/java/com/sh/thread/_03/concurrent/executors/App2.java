package com.sh.thread._03.concurrent.executors;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * <pre>
 *  Executors.newCachedThreadPool()
 *  - 쓰레드 제한이 없고, 작업이 할당되면 그에 필요한 쓰레드를 생성해 처리하는 방식
 *  - 업무종료된 쓰레드는 1분간 대기하다가 제거.
 *  - 짧고 반복되는 업무에 적합하다.
 *
 *
 * </pre>
 *
 */



public class App2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 2 ; i++) {

            //Variable used in lambda expression should be final or effectively final
            // 람다에서 사용하는 변수는 final이여야 함.
            // 함수형프로그램에서 함수(람다) 불변이어야 한다.
            // 지금 i 는 증감변수 이기때문에 변해서 못씀.. i를 이렇게 직접적으로 참조 x
            final int n = i; // 이렇게 해주면 n은 변하지 않기때문에 i만 변함. 변한 i값을 넣어줄뿐
            // int n = i; 라고 해도됨. 변하지 않는 것을 아니까
            executorService.submit(() -> System.out.println(Thread.currentThread().getName() + " " + "작업" + n));
            // 순서는 보장 x 그냥 하기만 하면 되기때문에
        }

        //1분 대기후 제거된 쓰레드 확인
        System.out.println(((ThreadPoolExecutor) executorService).getPoolSize()); // 이렇게 해줘야 getPoolSize 나옴 그냥 executorService하면 안나옴
        try {
            Thread.sleep(61 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(((ThreadPoolExecutor) executorService).getPoolSize());

        executorService.shutdown();

    }
}
