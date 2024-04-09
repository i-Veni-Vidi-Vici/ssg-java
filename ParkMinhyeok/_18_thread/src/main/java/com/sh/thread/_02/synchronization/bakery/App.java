package com.sh.thread._02.synchronization.bakery;

public class App {
    public static void main(String[] args) {
        Plate plate = new Plate();
        Thread consumer = new Thread(new Consumer(plate), "손님");
        Thread baker = new Thread(new Baker(plate), "요리사");
        consumer.start();
        baker.start();
    }
}
