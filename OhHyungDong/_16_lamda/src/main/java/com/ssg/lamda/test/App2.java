package com.ssg.lamda.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * <pre>
 *  Executors.newCachedThreadPool()
 *  - 쓰레수 제한이 없고, 작업이 할당되면 그에 필요한 쓰레드를 생성해 처리하는 방식
 *  - 업무종료된 쓰레드는 1분간 대기하다가 제거 .
 *  - 짧고 반복되는 업무에 적합
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 2; i++) {
            final int n = i;
            //함수형 프로그래밍에서 함수(람다) 불변이어야 한다.
            executorService.submit(() -> System.out.println(Thread.currentThread().getName() + "작업" + n));
        }
        // 1분 대기후 제거된 쓰레드 확인
        System.out.println(((ThreadPoolExecutor) executorService).getPoolSize());
        try{
            Thread.sleep(61 * 1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(((ThreadPoolExecutor) executorService).getPoolSize());

        executorService.shutdown();
    }
}
