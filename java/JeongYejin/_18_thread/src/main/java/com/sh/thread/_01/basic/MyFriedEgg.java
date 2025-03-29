package com.sh.thread._01.basic;

public class MyFriedEgg implements Runnable{
    String s = "🍳";

    public MyFriedEgg(String s) {
        this.s = s;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(s);
        }
        System.out.println("End of MyFriedEgg");
    }
}
