package com.sh.thread._01.basic;

import java.time.LocalTime;

/**
 * <pre>
 * 쓰레드제어 - Thread.sleep(millis:long)
 * - 해당 쓰레드를 지정한 millis초 만큼 일시정지 시킨다
 * - millis초 이후에는 다시 정상 작동한다
 * - InterruptedException에 대한 예외처리가 필수이다
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
//        for (int i=0;i<10;i++) {
//            try {
//
//                Thread.sleep(1000);
//                System.out.println("👩"+(i+1)+"번째 "+ LocalTime.now().getSecond()+"초");
//
//            }
//            catch (InterruptedException e) {
//                throw new RuntimeException(e);
//                //Checked예외를 다루기 쉬운 Unchecked예외로 전환
//            }
//        }
//        System.out.println(Thread.currentThread().getName());

        //1. 1초에 한번씩 피자를 출력하는 쓰레드 생성
        //extends Thread,
        PizzaThread pizzaThread=new PizzaThread();
        pizzaThread.setName("첫번째입니다");
        pizzaThread.start();

        //2. 1.5초에 한번씩 후라이를 출력하는 쓰레드 생성
        //implements Runnable
        // 이걸 더 선호하는 이유는 상속은 하나지만 implements는 여러가지를 가져 올 수 있다
//        Thread thread=new Thread(new EggThread());


        //이건 익명클래스, 왜냐 클래스내부 내용을 가져왔다 = 익명이다
//        Thread thread=new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for(int i=0;i<10;i++)
//                {
//                    try {
//                        Thread.sleep(1500);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    System.out.println((i+1)+"번째"+"🥗"+LocalTime.now().getSecond()+"초입니다");
//                }
//
//            }
//        });
        //이건 람다방식
        Thread thread=new Thread(()->
        {
            for(int i=0;i<10;i++)
                {
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println((i+1)+"번째"+"🥗"+LocalTime.now().getSecond()+"초입니다");
                }
        });
        thread.start();

    }

    private static class PizzaThread extends Thread{
        @Override
        public void run() {
            for(int i=0;i<10;i++)
            {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println((i+1)+"번째"+"🍕"+LocalTime.now().getSecond()+"초입니다");
            }
        }
    }

    private static class EggThread implements Runnable {
        @Override
        public void run() {
            for(int i=0;i<10;i++)
            {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println((i+1)+"번째"+"🥗"+LocalTime.now().getSecond()+"초입니다");
            }

        }
    }
}
