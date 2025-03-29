package com.sh.thread._01.basic;

public class PizzaThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("🍕");
        }
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        PizzaThread pizzaThread = new PizzaThread();
        pizzaThread.start();
    }
}

